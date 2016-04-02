package de.caluga.ergodox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * User: Stephan Bösebeck
 * Date: 01.04.16
 * Time: 09:59
 * <p>
 * TODO: Add documentation here
 */
public class KeymapParser {

    private StringBuilder fileContent;

    private enum State {
        START,
        KEYMAP,
        END,
        MACRO,
    }


    public Map<String, ErgodoxLayoutLayer> parse(String file) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String l = null;
        fileContent = new StringBuilder();
        while ((l = br.readLine()) != null) {
            fileContent.append(l + "\n");
        }

        int idx = 0;
        while (idx < fileContent.length()) {
            if (fileContent.charAt(idx) == '/' && fileContent.charAt(idx + 1) == '/') {
                //comment
                int start = idx;
                idx += 2;
                while (idx < fileContent.length() && fileContent.charAt(idx) != '\n') idx++;
                fileContent.replace(start, idx, "");
                idx = start;
            } else if (fileContent.charAt(idx) == '/' && fileContent.charAt(idx + 1) == '*') {
                int start = idx;
                idx += 2;
                while (idx < fileContent.length()) {
                    if (fileContent.charAt(idx) == '*' && fileContent.charAt(idx + 1) == '/') {
                        idx += 2;
                        break;
                    }
                    idx++;
                }
                fileContent.replace(start, idx, "");
                idx = start;
            } else {
                idx++;
            }
        }

        String keymapStart = "const uint16_t PROGMEM keymaps[][MATRIX_ROWS][MATRIX_COLS] = {";
        idx = fileContent.indexOf(keymapStart) + keymapStart.length();
        State state = State.START;
        int brCount = 0;
        Map<String, String> layerDefByName = new HashMap<>();
        String layerName = "";
        while (idx < fileContent.length()) {
            switch (state) {
                case START:
                    if (fileContent.charAt(idx) == '[') {
                        idx++;
                        int start = idx;
                        while (fileContent.charAt(idx) != ']') idx++;
                        layerName = fileContent.substring(start, idx);
                        System.out.println("Found layer " + layerName);
                    } else if (fileContent.charAt(idx) == '(') {
                        state = State.KEYMAP;
                        brCount = 1;
                    } else if (fileContent.charAt(idx) == ';') {
                        //End of keymap
                        System.out.println("End of keymap reached");
                        state = State.END;
                    }
                    break;
                case KEYMAP:
                    int start = idx;
                    while (brCount > 0) {
                        if (fileContent.charAt(idx) == '(') brCount++;
                        if (fileContent.charAt(idx) == ')') brCount--;
                        idx++;
                    }
                    String keyMap = fileContent.substring(start, idx - 1);
                    System.out.println("Keymap: " + keyMap);
                    layerDefByName.put(layerName, keyMap);
                    state = State.START;
            }
            idx++;
        }

        Map<String, ErgodoxLayoutLayer> ret = new LinkedHashMap<>();
        for (String ln : layerDefByName.keySet()) {
            ErgodoxLayoutLayer layer = parseLayer(layerDefByName.get(ln));
            layer.setName(ln);
            ret.put(ln, layer);
        }
        return ret;
//        System.out.println(fileContent.toString());
    }

    private ErgodoxLayoutLayer parseLayer(String l) {
        int idx = 0;
        int keyIndex = 0;
        ErgodoxLayoutLayer layer = new ErgodoxLayoutLayer();
        StringBuilder key = new StringBuilder();
        int skip = 0;
        while (idx < l.length()) {
            if (l.charAt(idx) == ' ' || l.charAt(idx) == '\n' || l.charAt(idx) == '\t' || l.charAt(idx) == '\r') {
                idx++;
                continue;
            }
            if (l.charAt(idx) == ',' && skip == 0) {
                //end of key
                setKeyValue(keyIndex, layer, key);
                keyIndex++;
                key.setLength(0);
                idx++;
                continue;
            } else if (l.charAt(idx) == '(') {
                skip++;
            } else if (l.charAt(idx) == ')') {
                skip--;
            }
            key.append(l.charAt(idx));
            idx++;
        }
        setKeyValue(keyIndex, layer, key);
        return layer;
    }

    private void setKeyValue(int keyIndex, ErgodoxLayoutLayer layer, StringBuilder key) {

        layer.getKey(keyIndex).setValue(key.toString());
    }
}
