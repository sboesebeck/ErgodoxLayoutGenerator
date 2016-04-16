/*
 * Copyright © 2007 Free Software Foundation, Inc. <http://fsf.org/>
 *
 * Everyone is permitted to copy and distribute verbatim copies of this license document, but changing it is not allowed.
 *
 * This version of the GNU Lesser General Public License incorporates the terms and conditions of version 3 of the GNU General Public License, supplemented by the additional permissions listed below.
 *
 * 0. Additional Definitions.
 * As used herein, “this License” refers to version 3 of the GNU Lesser General Public License, and the “GNU GPL” refers to version 3 of the GNU General Public License.
 *
 * “The Library” refers to a covered work governed by this License, other than an Application or a Combined Work as defined below.
 *
 * An “Application” is any work that makes use of an interface provided by the Library, but which is not otherwise based on the Library. Defining a subclass of a class defined by the Library is deemed a mode of using an interface provided by the Library.
 *
 * A “Combined Work” is a work produced by combining or linking an Application with the Library. The particular version of the Library with which the Combined Work was made is also called the “Linked Version”.
 *
 * The “Minimal Corresponding Source” for a Combined Work means the Corresponding Source for the Combined Work, excluding any source code for portions of the Combined Work that, considered in isolation, are based on the Application, and not on the Linked Version.
 *
 * The “Corresponding Application Code” for a Combined Work means the object code and/or source code for the Application, including any data and utility programs needed for reproducing the Combined Work from the Application, but excluding the System Libraries of the Combined Work.
 *
 * 1. Exception to Section 3 of the GNU GPL.
 * You may convey a covered work under sections 3 and 4 of this License without being bound by section 3 of the GNU GPL.
 *
 * 2. Conveying Modified Versions.
 * If you modify a copy of the Library, and, in your modifications, a facility refers to a function or data to be supplied by an Application that uses the facility (other than as an argument passed when the facility is invoked), then you may convey a copy of the modified version:
 *
 * a) under this License, provided that you make a good faith effort to ensure that, in the event an Application does not supply the function or data, the facility still operates, and performs whatever part of its purpose remains meaningful, or
 * b) under the GNU GPL, with none of the additional permissions of this License applicable to that copy.
 * 3. Object Code Incorporating Material from Library Header Files.
 * The object code form of an Application may incorporate material from a header file that is part of the Library. You may convey such object code under terms of your choice, provided that, if the incorporated material is not limited to numerical parameters, data structure layouts and accessors, or small macros, inline functions and templates (ten or fewer lines in length), you do both of the following:
 *
 * a) Give prominent notice with each copy of the object code that the Library is used in it and that the Library and its use are covered by this License.
 * b) Accompany the object code with a copy of the GNU GPL and this license document.
 * 4. Combined Works.
 * You may convey a Combined Work under terms of your choice that, taken together, effectively do not restrict modification of the portions of the Library contained in the Combined Work and reverse engineering for debugging such modifications, if you also do each of the following:
 *
 * a) Give prominent notice with each copy of the Combined Work that the Library is used in it and that the Library and its use are covered by this License.
 * b) Accompany the Combined Work with a copy of the GNU GPL and this license document.
 * c) For a Combined Work that displays copyright notices during execution, include the copyright notice for the Library among these notices, as well as a reference directing the user to the copies of the GNU GPL and this license document.
 * d) Do one of the following:
 * 0) Convey the Minimal Corresponding Source under the terms of this License, and the Corresponding Application Code in a form suitable for, and under terms that permit, the user to recombine or relink the Application with a modified version of the Linked Version to produce a modified Combined Work, in the manner specified by section 6 of the GNU GPL for conveying Corresponding Source.
 * 1) Use a suitable shared library mechanism for linking with the Library. A suitable mechanism is one that (a) uses at run time a copy of the Library already present on the user's computer system, and (b) will operate properly with a modified version of the Library that is interface-compatible with the Linked Version.
 * e) Provide Installation Information, but only if you would otherwise be required to provide such information under section 6 of the GNU GPL, and only to the extent that such information is necessary to install and execute a modified version of the Combined Work produced by recombining or relinking the Application with a modified version of the Linked Version. (If you use option 4d0, the Installation Information must accompany the Minimal Corresponding Source and Corresponding Application Code. If you use option 4d1, you must provide the Installation Information in the manner specified by section 6 of the GNU GPL for conveying Corresponding Source.)
 * 5. Combined Libraries.
 * You may place library facilities that are a work based on the Library side by side in a single library together with other library facilities that are not Applications and are not covered by this License, and convey such a combined library under terms of your choice, if you do both of the following:
 *
 * a) Accompany the combined library with a copy of the same work based on the Library, uncombined with any other library facilities, conveyed under the terms of this License.
 * b) Give prominent notice with the combined library that part of it is a work based on the Library, and explaining where to find the accompanying uncombined form of the same work.
 * 6. Revised Versions of the GNU Lesser General Public License.
 * The Free Software Foundation may publish revised and/or new versions of the GNU Lesser General Public License from time to time. Such new versions will be similar in spirit to the present version, but may differ in detail to address new problems or concerns.
 *
 * Each version is given a distinguishing version number. If the Library as you received it specifies that a certain numbered version of the GNU Lesser General Public License “or any later version” applies to it, you have the option of following the terms and conditions either of that published version or of any later version published by the Free Software Foundation. If the Library as you received it does not specify a version number of the GNU Lesser General Public License, you may choose any version of the GNU Lesser General Public License ever published by the Free Software Foundation.
 *
 * If the Library as you received it specifies that a proxy can decide whether future versions of the GNU Lesser General Public License shall apply, that proxy's public statement of acceptance of any version is permanent authorization for you to choose that version for the Library.
 */

package de.caluga.ergodox;

import de.caluga.ergodox.macros.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;


/**
 * User: Stephan Bösebeck
 * Date: 01.04.16
 * Time: 09:59
 * <p>
 * TODO: Add documentation here
 */
public class KeymapParser {

    private StringBuilder fileContent;



    public static List<MacroAction> parseActionList(String typing) {
        List<MacroAction> list = new ArrayList<>();
        for (String token : typing.split(",")) {
            MacroAction a = parseMacroAction(token);
            if (a == null) continue;
            list.add(a);
        }
        return list;
    }

    public static MacroAction parseMacroAction(String token) {
        MacroAction a = new MacroAction();
        if (token.startsWith("D(")) {
            a.setAction(MacroAction.Action.DOWN);
            a.setCode(ErgodoxKeyCode.valueOf("KC_" + token.substring(2, token.length() - 1)));

        } else if (token.startsWith("U(")) {
            a.setAction(MacroAction.Action.UP);
            a.setCode(ErgodoxKeyCode.valueOf("KC_" + token.substring(2, token.length() - 1)));

        } else if (token.startsWith("T(")) {
            a.setAction(MacroAction.Action.TYPE);
            a.setCode(ErgodoxKeyCode.valueOf("KC_" + token.substring(2, token.length() - 1)));
        } else if (token.startsWith("W(")) {
            a.setAction(MacroAction.Action.WAIT);
            a.setWait(Integer.parseInt(token.substring(2, token.length() - 1)));
        } else {
            throw new RuntimeException("Cannot handle Macro action " + token);
        }
        return a;
    }

    public ErgodoxLayout parse(String file) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String l;
        fileContent = new StringBuilder();
        while ((l = br.readLine()) != null) {
            fileContent.append(l);
            fileContent.append("\n");
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
        String macroStart = "const macro_t *action_get_macro(keyrecord_t *record, uint8_t id, uint8_t opt)";
        String ledStart = "void matrix_scan_user(void) {";
        idx = fileContent.indexOf(keymapStart) + keymapStart.length();
        State state = State.START;
        int brCount = 0;
        Map<String, String> layerDefByName = new LinkedHashMap<>();
        String layerName = "";
        //parse layer definitions
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


        //parse LED settings for layers
        idx=fileContent.indexOf(ledStart)+ledStart.length();
        brCount =1;
        int start=idx;
        idx = getTextBetweenBraces(idx, brCount);

        String ledMethod=fileContent.substring(start,idx);
        for (String keyMap:layerDefByName.keySet()){
            int caseStart=ledMethod.indexOf("case "+keyMap);
            if(caseStart==-1){
                System.out.println("No LED settings for layer "+keyMap);
                continue;
            }
            int endCase=ledMethod.indexOf("break;",caseStart);
            //between those indexes, the led settings will be
            String c=ledMethod.substring(caseStart,endCase);
            ret.get(keyMap).setLed1(c.contains("ergodox_right_led_1_on();"));
            ret.get(keyMap).setLed2(c.contains("ergodox_right_led_2_on();"));
            ret.get(keyMap).setLed3(c.contains("ergodox_right_led_3_on();"));
        }

        idx = fileContent.indexOf(macroStart) + macroStart.length();
        idx = fileContent.indexOf("{", idx) + 1;
        start = idx;
        idx = getTextBetweenBraces(idx, brCount);
        String macros = fileContent.substring(start, idx);

        Map<String, Macro> keymapMacros = new LinkedHashMap();

        while (macros.length() > 0) {
            idx = macros.indexOf("case ");
            if (idx == -1) break;
            idx += 5;
            String macroName = macros.substring(idx, macros.indexOf(":", idx));
            System.out.println("Found macro " + macroName);

            String originalMacroContent = macros.substring(macros.indexOf(":", idx) + 1, macros.indexOf("break;", idx));
            String normalizedMacroContent = originalMacroContent.replaceAll("[\n\t ]", "");
            Matcher mTypingMacro = TypeMacro.pattern.matcher(normalizedMacroContent);
            Matcher mLayerToggleMacro = LayerToggleMacro.pattern.matcher(normalizedMacroContent);
            Matcher mLTTypeMacro = LongPressAndTypeMacro.pattern.matcher(normalizedMacroContent);
            Matcher mHoldKeyMacro = HoldKeyMacro.pattern.matcher(normalizedMacroContent);
            Macro macro;
            if (mTypingMacro.matches()) {
                String typing = mTypingMacro.group(1);
                System.out.println("Regular typing macro: " + typing);
                TypeMacro tm = new TypeMacro();

                List<MacroAction> list = parseActionList(typing);
                tm.setActions(list);
                System.out.println("Got Macro: " + tm.toString());
                macro = tm;

            } else if (mHoldKeyMacro.matches()) {
                System.out.println("HoldKeyMacro matches!");
                System.out.println("OnKeyPress: " + mHoldKeyMacro.group(1) + "  onRelease: " + mHoldKeyMacro.group(2));
                HoldKeyMacro hkm = new HoldKeyMacro();
                hkm.setOnPress(parseActionList(mHoldKeyMacro.group(1)));
                hkm.setOnRelease(parseActionList(mHoldKeyMacro.group(2)));
                macro = hkm;
            } else if (mLTTypeMacro.matches()) {
                System.out.println("Got longPress Macro; onPress: " + mLTTypeMacro.group(1) + "  timeout: " + mLTTypeMacro.group(2) + "  release: " + mLTTypeMacro.group(3) + "  type: " + mLTTypeMacro.group(4));
                LongPressAndTypeMacro lt = new LongPressAndTypeMacro();
                List<MacroAction> lst = parseActionList(mLTTypeMacro.group(1));
                lt.setLongPressKeys(lst);
                lt.setTimeout(Integer.parseInt(mLTTypeMacro.group(2)));
                lt.setShortStrokes(parseActionList(mLTTypeMacro.group(4)));
                //group 3 should only contain the Up-calls for group 1!
                //Sanity check
                List<ErgodoxKeyCode> pressedKeys = new ArrayList<>();
                for (MacroAction m : lt.getLongPressKeys()) {
                    switch (m.getAction()) {
                        case DOWN:
                            pressedKeys.add(m.getCode());
                            break;
                        case UP:
                            pressedKeys.remove(m.getCode());
                            break;
                    }
                }
                List<MacroAction> releases = parseActionList(mLTTypeMacro.group(3));
                for (MacroAction a : releases) {
                    switch (a.getAction()) {
                        case UP:
                            pressedKeys.remove(a.getCode());
                            break;
                    }
                }
                if (pressedKeys.size() != 0) {
                    System.err.println("Warning, some keys are not properly released after macro: ");
                    for (ErgodoxKeyCode k : pressedKeys) {
                        System.err.println(k.toString());
                    }
                }
                macro = lt;

            } else if (mLayerToggleMacro.matches()) {
                System.out.println("Layer toggle macro: Layer " + mLayerToggleMacro.group(1));
                LayerToggleMacro lm = new LayerToggleMacro();
                lm.setLayer(mLayerToggleMacro.group(1));
                lm.setName(macroName);
                macro = lm;
            } else {
                System.out.println("Unknown custom macro?");
                System.out.println(normalizedMacroContent);
                CustomMacro cm = new CustomMacro();
                cm.setContent(originalMacroContent);
                macro = cm;
            }
            macro.setName(macroName);

            macros = macros.substring(macros.indexOf("break;", idx));
            //Does not work if you have nested case statements!!!!!
            keymapMacros.put(macroName, macro);

        }

        ErgodoxLayout layout = new ErgodoxLayout();
        layout.setLayers(ret);
        layout.setMacros(keymapMacros);
        return layout;
//        System.out.println(fileContent.toString());
    }

    private int getTextBetweenBraces(int idx, int brCount) {
        while (idx < fileContent.length()) {
            if (fileContent.charAt(idx) == '{') {
                brCount++;
            }
            if (fileContent.charAt(idx) == '}') {
                brCount--;
                if (brCount == 0) break;
            }
            idx++;
        }
        return idx;
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

    private enum State {
        START,
        KEYMAP,
        END,
        MACRO,
    }
}
