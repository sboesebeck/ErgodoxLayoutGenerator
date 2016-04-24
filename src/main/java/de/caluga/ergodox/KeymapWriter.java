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
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * User: Stephan Bösebeck
 * Date: 14.04.16
 * Time: 22:36
 * <p>
 * TODO: Add documentation here
 */
public class KeymapWriter {

    public static void macroActionListToCString(StringBuilder b, List<MacroAction> actions) {
        for (MacroAction a : actions) {
            b.append(a.getAction().name());

            b.append("(");
            if (a.getAction().equals(MacroAction.Action.WAIT) || a.getAction().equals(MacroAction.Action.INTERVAL))
                b.append(a.getWait());
            else {
                b.append(a.getCode().name());
            }
            b.append(")");
            b.append(",");
        }
    }

    public void writeKeymapFile(ErgodoxLayout layout, File to) throws Exception {
        Configuration cfg = new Configuration(new Version(2, 3, 4));
        cfg.setClassForTemplateLoading(KeymapWriter.class, "/");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Template template = cfg.getTemplate("keymap.ftl");

        Map<String, Object> model = new HashMap<>();
        model.put("layout", layout);
        model.put("name", to.getName());
        model.put("version", Main.VERSION);


        Map<String, String> macroContentByName = new HashMap<>();

        for (String macroName : layout.getMacros().keySet()) {
            StringBuilder b = new StringBuilder();
            b.append("//Macro: " + macroName);
            b.append("//-----------------------\n");
            if (layout.getMacros().get(macroName) instanceof TypeMacro) {
                TypeMacro tm = (TypeMacro) layout.getMacros().get(macroName);
                b.append("if (record->event.pressed) {\n" +
                        "\t\t\treturn MACRO(");
                macroActionListToCString(b, tm.getActions());
                b.append("END);\n");
                b.append("\t\t}\n");
            } else if (layout.getMacros().get(macroName) instanceof LongPressAndTypeMacro) {
                LongPressAndTypeMacro lp = (LongPressAndTypeMacro) layout.getMacros().get(macroName);
                b.append("if (record->event.pressed) {\n" +
                        "\t\t\tstart = timer_read();\n" +
                        "\t\t\treturn ");
                b.append("MACRO(");
                macroActionListToCString(b, lp.getLongPressKeys());
                b.append("END);\n");
                b.append("\t\t} else {\n");
                b.append("\t\t\tif (timer_elapsed(start) >").append(lp.getTimeout()).append(") {\n");
                b.append("\t\t\t\treturn MACRO(");
                getReleaseCString(b, lp.getLongPressKeys());
                b.append("END);\n");
                b.append("\t\t\t} else {\n");
                b.append("\t\t\t\treturn MACRO(");
                macroActionListToCString(b, lp.getShortStrokes());
                b.append("END);\n");
                b.append("\t\t\t}\n" +
                        "\t\t}\n");
            } else if (layout.getMacros().get(macroName) instanceof HoldKeyMacro) {
                HoldKeyMacro hm = (HoldKeyMacro) layout.getMacros().get(macroName);
                b.append("if (record->event.pressed){\n" +
                        "\t\t\treturn MACRO(");
                macroActionListToCString(b, hm.getOnPress());
                b.append("END);\n");
                b.append("\t\t}else{\n" +
                        "\t\t\treturn MACRO(");
                macroActionListToCString(b, hm.getOnRelease());
                getReleaseCString(b, hm.getOnPress()); //Make sure, all DOWNS are UPs TODO: check if double UPs cause problems!
                b.append("END);\n\t\t}\n");
            } else if (layout.getMacros().get(macroName) instanceof LayerToggleTypeMacro) {
                LayerToggleTypeMacro ltt = (LayerToggleTypeMacro) layout.getMacros().get(macroName);
                b.append("if (record->event.pressed) {\n" +
                        "\t\t\tstart = timer_read();\n");
                b.append("           layer_state ^= (1<<").append(ltt.getLayer()).append(");\n");
                b.append("           layer_state &= (1<<").append(ltt.getLayer()).append(");\n");
                b.append("\t\t\treturn MACRO_NONE; ");
                b.append("\t\t} else {\n");
                b.append("           layer_state ^= (1<<").append(ltt.getLayer()).append(");\n");
                b.append("           layer_state &= (1<<").append(ltt.getLayer()).append(");\n");
                b.append("\t\t\tif (timer_elapsed(start) >").append(ltt.getTimeout()).append(") {\n");
                b.append("\t\t\t\treturn MACRO_NONE;\n");
                b.append("\t\t\t} else {\n");
                b.append("\t\t\t\treturn MACRO(");
                macroActionListToCString(b, ltt.getActionsOnType());
                b.append("END);\n");
                b.append("\t\t\t}\n" +
                        "\t\t}\n");
            } else if (layout.getMacros().get(macroName) instanceof LayerToggleAndHoldMacro) {
                LayerToggleAndHoldMacro lth = (LayerToggleAndHoldMacro) layout.getMacros().get(macroName);
                b.append("if (record->event.pressed){\n" + "         start = timer_read();\n" + "         layer_state ^=(1<<")
                        .append(lth.getLayer())
                        .append(");\n")
                        .append("         layer_state &=(1<<")
                        .append(lth.getLayer()).append(");\n")
                        .append(" } else {\n")
                        .append("         if (timer_elapsed(start) > ")
                        .append(lth.getTimeout())
                        .append(") {\n")
                        .append("                 layer_state^=(1<<")
                        .append(lth.getLayer())
                        .append(");\n").append("                 layer_state&=(1<<")
                        .append(lth.getLayer())
                        .append(");\n").append("         }\n")
                        .append(" }\n")
                        .append("return MACRO_NONE;\n");
            } else if (layout.getMacros().get(macroName) instanceof LayerToggleMacro) {
                LayerToggleMacro lt = (LayerToggleMacro) layout.getMacros().get(macroName);
                b.append(" if (record->event.pressed){\n" +
                        "           layer_state ^= (1<<").append(lt.getLayer()).append(");\n" +
                        "           layer_state &= (1<<").append(lt.getLayer()).append(");\n" +
                        "        }\n");
            } else if (layout.getMacros().get(macroName) instanceof CustomMacro) {
                CustomMacro cm = (CustomMacro) layout.getMacros().get(macroName);
                b.append(cm.getContent());
            }
            macroContentByName.put(macroName, b.toString());
        }
        model.put("macros", macroContentByName);

        //generate ascii legend
        StringBuilder asciiLegend = new StringBuilder();

        Map<String, String> legendByName = new HashMap<>();

        for (String lName : layout.getLayers().keySet()) {
            ErgodoxLayoutLayer l = layout.getLayers().get(lName);
            int maxLen = 0;
            for (Key k : l.getLayout()) {
                String keyDisplayText = Main.getKeyDisplayText(k.getValue(), layout.getMacros());
                if (keyDisplayText.length() > maxLen) maxLen = keyDisplayText.length();
            }
            maxLen += 2; //space left and right
            int row = 0;
            int rowidx = 0;
            for (int idx = 0; idx < l.getLayout().size() / 2; idx++, rowidx++) {
                if (rowidx >= l.getRowLength().get(row)) {
                    row++;
                    rowidx = 0;
                    asciiLegend.append("\n");
                    asciiLegend.append("---------------------------------------");
                }

                asciiLegend.append("");
            }
        }

        template.process(model, new FileWriter(to));
    }

    public void getReleaseCString(StringBuilder b, List<MacroAction> lst) {
        for (MacroAction a : lst) {
            switch (a.getAction()) {
                case DOWN:
                    b.append("U(").append(a.getCode().name().substring(3)).append("),");
            }
        }
    }
}
