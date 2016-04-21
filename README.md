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

## running it

Prerequisites: have a proper jdk or jre (Java Version) installed. This works best with the official oracle JDK, but openjdk also work. You need to install the jfx support for openjdk in oder to get it to run. On ubuntu for example you need to run `apt-get install openjfx`

If java is installed and available, you can download a release from this github page (see under releases) and execute the jar by eithter clicking on it or - if you want to use the commandline - run it with `java -jar ergodoxlayoutgenerator-1.0RC2.jar` 

## compiling it

just clone the whole project onto your local drive and then run `mvn install` in the directory. The prerequisites are the same as for running it, but in this case you'd need to have a JDK installed, a JRE would not be working, as it does not inculde a compiler.

In addition to that you need to have maven installed.

## Documentation

The documentation is available at <https://boesebeck.name/2016/04/16/ergodoxlayoutgenerator-documentation/>

In short:

- when opening the ELG, it will show an empty layout
- you should set the QMK-Sourcedir in order to be able to compile your layout. You should also store your layout at the proper directory _within_ the qmk-sources. Otherwise, the compile will not work
- use open to choose a layout from the existing ones in the QMK-Directory. You need to choose the directory, all layout files are named `keymap.c`
- the reopen button would read in the layout you opened last or saved last
- save will save your layout. Again, you need to chosse a directory! If you want to create a new layout, create a new directory with the name for your layout in the qmk source. If you set the sourcedir properly, the dialog will start in the right place
- savePng will store a documenting PNG of your layout. Showing all layers an macros. Kind of a "Cheat sheet"
- compile - this will compile your layout. Be careful that you saved before that! If compilation is successful, you will be asked if you want to move the resulting `.hex` file to the "proper" location - which is beside the keymap.c file
- create will create a new empty layout

**Caveat** Be careful: there are not any "security" questions asked. Meaning, if you hit the create button, you will lose everything that is not saved! No questions asked yet!

Klicking on a key representation with the right mousebutton will bring up a menu where you can assign different actions to the corresponding key. 

- Assign key - just a simple keypress
- Assign Layertoggle - pressing the key will switch to a different layer, typing it again will switch back
- Assign Layertoggle / Type - when holding the key, switch to a layer, when typing or tapping it just a normal key
- Assign Macro

With Macros you can significantly improve things you can do with your keyboard. But of course, the ELG cannot do _everything_ you could do by programming c-code, but it does solve some very common features with these macro types:

- type macro: will type a series of keys when the key this macro is assigned to is pressed.
- long press type macro: when you hold the key there will be a different set of actions then when typing. Just be careful: you need to release the keys during hold at the end of the type action list!
- hold key makro: well, do something when holding the key, and when releasing it again
- custom macro: here you could actually add c-code
- layergoggle macro: toggle between layers. this type also supports: holding key, switch to the layer as long the key is held, tapping the key, just toggle the layer
- layertoggle type macro: when the key is tapped, a normal macro is executed, when  the key is held, a layer switch takes place

You might ask, why are there some macros exactly copying the standard features, like LT()?
Thing is, that LT does not work good with combinations of keys. For example, you want to switch to a layer, if the key is held, but want it to type SHIFT-1 (for !) when typed. This will not work without the macro.


## Disclaimer

 Use this code at your own risk! If the resulting keymap.c does not work as expected or is - what I think is not possible, but anyway - harm your device, the author of this tool is not responsible.

This tool was _not_ heavily tested on different environments, if you find any bugs, please consider posting them on the project page on github. 


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

