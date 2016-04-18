# ErgodoxLayoutGenerator

This little program was developed as a proof of concept. The idea was to achieve the following goals:

- creating the PNGs for your layout of the ergodox firmware (download it [here](https://github.com/jackhumbert/qmk_firmware) or
my simple fork [here](https://github.com/sboesebeck/qmk_firmware)) can be very complicated and for now is a manual process.
The program should make it possible to create an overview PNG very easy
- all c-files building the keymap look more or less the same. It should be able to parse those files or at least the "interesting"
parts of it to be able to create a good overview image
- it should also parse macro info. As I see it now, there are not many different macros in use out there. Most of them are either
just typing text (or a combination of keys/modifiers), create a different behaviour on long pressing the key vs. typing it,
or toggle a certain layer.
- maybe, if possible, it should make you able to create your own layouts. If the display is valid, it should be not a big deal, to
 also save the layout file.

 Of course this will all only be possible to a certain extent. The parsing of the C-File will only work, if the file will stay
 in a certain structure. And if that structure changes somehow in future, this program also needs to adapt.

 And: Even if there is some kind of Macro support possible, it will never be the same as coding it yourself. Although it
 might be possible to have that done also in the _ErgodoxLayoutGenerator_, this will still be limited in functionality.

 ## Documentation

 When starting the program, it will show an empty ErgoDox (or ErgoDox-EZ in that respect)
 layout.
 When you click on a key representation, it will be marked. Rightclicking on it will then show a context menu where you can either assign a key, a macro or similar function
 when doubleclicking you will either edit the current assignment or assign a key.

 When you're finished with your layout, you can easily store it as `keamap.c` file. You need to specify a _directory_ where you want to store it.
 The directory should reside in the `qmk-sourcedir`, in order to be able to be compileable.

 There is a compile button, where you can have your keymap compiled - do not forget to save your changes before trying to compile.

 You can also open an existing keymap file. You should sett the QMK-Sourcedir in order to find the keymap more easily.
 This setting will be stored for the next start, so you can easily re-open any keymap you worked on.

 When you click on the Button "open", it will show you the current available layouts in your qmk-sourcedir. You need only choose
 the directory in which the `keymap.c` file is located.

 After the keymap was parsed and opened you can now see the layout of `BASE`. The parsing only works properly, if all layers do have
 a name (Usually done using `#define` at the top of the file). If that is missing, the parsing might (or will) fail.

 You can switch between your layers using the topleft combobox. There all available layers should be shown.
 when you change the layer, the gui is updated, you will see the layout accordingly.

 The different colors do have a meaning, the legend of them is shown just below the keys. Some of those do have two lines of "text"
 the description in the legend is then according to the line.

 The buttn "save" does not work now, but would store your changes to the `keymap.c` file. The button "create" does not work
 yet either. But it will create a complete new layout in the qmk sourcedir.

 The button "save PNG" renders an image with all the layers of the currently open keymap and stores it to the given file.
 By default it is called "KEYMAPNAME_highres.png" (where KEYMAPNAME is replaced by the name of your keymap)
 and would be stored in the keymap directory (as documentation).


documentation is also available at <https://boesebeck.name/2016/04/16/ergodoxlayoutgenerator-documentation/>

## Disclaimer

 This code is in a very early development stage, more like a prototype and proof of concept. The code is still in prototype
 level and not really "good". But it seems to work for now.

 Also this Softare was not heavily tested on different machines, different OS. If you find an error, plese leave an issue on the github page.

 ## Copyright
 Copyright © 2007 Free Software Foundation, Inc. <http://fsf.org/>

 Everyone is permitted to copy and distribute verbatim copies of this license document, but changing it is not allowed.

 This version of the GNU Lesser General Public License incorporates the terms and conditions of version 3 of the GNU General Public License, supplemented by the additional permissions listed below.

 0. Additional Definitions.
 As used herein, “this License” refers to version 3 of the GNU Lesser General Public License, and the “GNU GPL” refers to version 3 of the GNU General Public License.

 “The Library” refers to a covered work governed by this License, other than an Application or a Combined Work as defined below.

 An “Application” is any work that makes use of an interface provided by the Library, but which is not otherwise based on the Library. Defining a subclass of a class defined by the Library is deemed a mode of using an interface provided by the Library.

 A “Combined Work” is a work produced by combining or linking an Application with the Library. The particular version of the Library with which the Combined Work was made is also called the “Linked Version”.

 The “Minimal Corresponding Source” for a Combined Work means the Corresponding Source for the Combined Work, excluding any source code for portions of the Combined Work that, considered in isolation, are based on the Application, and not on the Linked Version.

 The “Corresponding Application Code” for a Combined Work means the object code and/or source code for the Application, including any data and utility programs needed for reproducing the Combined Work from the Application, but excluding the System Libraries of the Combined Work.

 1. Exception to Section 3 of the GNU GPL.
 You may convey a covered work under sections 3 and 4 of this License without being bound by section 3 of the GNU GPL.

 2. Conveying Modified Versions.
 If you modify a copy of the Library, and, in your modifications, a facility refers to a function or data to be supplied by an Application that uses the facility (other than as an argument passed when the facility is invoked), then you may convey a copy of the modified version:

 a) under this License, provided that you make a good faith effort to ensure that, in the event an Application does not supply the function or data, the facility still operates, and performs whatever part of its purpose remains meaningful, or
 b) under the GNU GPL, with none of the additional permissions of this License applicable to that copy.
 3. Object Code Incorporating Material from Library Header Files.
 The object code form of an Application may incorporate material from a header file that is part of the Library. You may convey such object code under terms of your choice, provided that, if the incorporated material is not limited to numerical parameters, data structure layouts and accessors, or small macros, inline functions and templates (ten or fewer lines in length), you do both of the following:

 a) Give prominent notice with each copy of the object code that the Library is used in it and that the Library and its use are covered by this License.
 b) Accompany the object code with a copy of the GNU GPL and this license document.
 4. Combined Works.
 You may convey a Combined Work under terms of your choice that, taken together, effectively do not restrict modification of the portions of the Library contained in the Combined Work and reverse engineering for debugging such modifications, if you also do each of the following:

 a) Give prominent notice with each copy of the Combined Work that the Library is used in it and that the Library and its use are covered by this License.
 b) Accompany the Combined Work with a copy of the GNU GPL and this license document.
 c) For a Combined Work that displays copyright notices during execution, include the copyright notice for the Library among these notices, as well as a reference directing the user to the copies of the GNU GPL and this license document.
 d) Do one of the following:
 0) Convey the Minimal Corresponding Source under the terms of this License, and the Corresponding Application Code in a form suitable for, and under terms that permit, the user to recombine or relink the Application with a modified version of the Linked Version to produce a modified Combined Work, in the manner specified by section 6 of the GNU GPL for conveying Corresponding Source.
 1) Use a suitable shared library mechanism for linking with the Library. A suitable mechanism is one that (a) uses at run time a copy of the Library already present on the user's computer system, and (b) will operate properly with a modified version of the Library that is interface-compatible with the Linked Version.
 e) Provide Installation Information, but only if you would otherwise be required to provide such information under section 6 of the GNU GPL, and only to the extent that such information is necessary to install and execute a modified version of the Combined Work produced by recombining or relinking the Application with a modified version of the Linked Version. (If you use option 4d0, the Installation Information must accompany the Minimal Corresponding Source and Corresponding Application Code. If you use option 4d1, you must provide the Installation Information in the manner specified by section 6 of the GNU GPL for conveying Corresponding Source.)
 5. Combined Libraries.
 You may place library facilities that are a work based on the Library side by side in a single library together with other library facilities that are not Applications and are not covered by this License, and convey such a combined library under terms of your choice, if you do both of the following:

 a) Accompany the combined library with a copy of the same work based on the Library, uncombined with any other library facilities, conveyed under the terms of this License.
 b) Give prominent notice with the combined library that part of it is a work based on the Library, and explaining where to find the accompanying uncombined form of the same work.
 6. Revised Versions of the GNU Lesser General Public License.
 The Free Software Foundation may publish revised and/or new versions of the GNU Lesser General Public License from time to time. Such new versions will be similar in spirit to the present version, but may differ in detail to address new problems or concerns.

 Each version is given a distinguishing version number. If the Library as you received it specifies that a certain numbered version of the GNU Lesser General Public License “or any later version” applies to it, you have the option of following the terms and conditions either of that published version or of any later version published by the Free Software Foundation. If the Library as you received it does not specify a version number of the GNU Lesser General Public License, you may choose any version of the GNU Lesser General Public License ever published by the Free Software Foundation.

 If the Library as you received it specifies that a proxy can decide whether future versions of the GNU Lesser General Public License shall apply, that proxy's public statement of acceptance of any version is permanent authorization for you to choose that version for the Library.

