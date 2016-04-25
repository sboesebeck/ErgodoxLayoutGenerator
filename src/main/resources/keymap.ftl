#include "ergodox_ez.h"
#include "debug.h"
#include "action_layer.h"
#include "keymap_extras/keymap_french.h"
#include "keymap_extras/keymap_neo2.h"
#include "keymap_extras/keymap_uk.h"
#include "keymap_extras/keymap_colemak.h"
#include "keymap_extras/keymap_french_osx.h"
#include "keymap_extras/keymap_nordic.h"
#include "keymap_extras/keymap_dvorak.h"
#include "keymap_extras/keymap_german.h"
#include "keymap_extras/keymap_norwegian.c"
#include "keymap_extras/keymap_fr_ch.h"
#include "keymap_extras/keymap_german_osx.h"
#include "keymap_extras/keymap_spanish.h"
#include "keymap_extras/keymap_bepo.h"


/**
* This layout was generated using the ErgodoxLayoutGenerator (ELG). You can download it from https://github.com/sboesebeck/ErgodoxLayoutGenerator/releases
* documentation about it can be found here https://boesebeck.name/2016/04/16/ergodoxlayoutgenerator-documentation/
* Thanks to the team of Erez Zukerman for building the great Ergodox-EZ!
*
* use at own risk!
**/

<#list layout.layers?keys as layer>
#define ${layer} ${layer?index}
</#list>

<#list layout.macros?keys as macro>
#define ${macro} ${macro?index}
</#list>

//Layout ${name!} generated with ${version}
const uint16_t PROGMEM keymaps[][MATRIX_ROWS][MATRIX_COLS] = {
<#list layout.layers?keys as layer>
    <#assign rowidx=0>
    <#assign row=0>
/**
* Layer: ${layer}
${asciilegend[layer]}
**/
[${layer}]=KEYMAP(
    <#assign l=layout.layers[layer]/>
//left half
    <#list layout.layers[layer].layout as key><#if key.skip>       <#else><#assign rowidx=rowidx+1/>${key.value!}<#sep>, <#if (rowidx>=l.rowLength[row] )><#assign row=row+1/><#if (row<l.rowLength?size && l.rowLength[row]==0)><#assign row=row+1/></#if><#assign rowidx =0><#if (row >=l.rowLength?size)><#assign row=0>
    //right half</#if>
    </#if></#if></#list>),
</#list>
};

const uint16_t PROGMEM fn_actions[] = {

};

const macro_t *action_get_macro(keyrecord_t *record, uint8_t id, uint8_t opt)
{
static uint16_t start;
switch(id) {
<#list macros?keys as macro>
case ${macro}:
${macros[macro]}
break;
</#list>
}
return MACRO_NONE;
};

// Runs just one time when the keyboard initializes.
void matrix_init_user(void) {

};

// Runs constantly in the background, in a loop.
void matrix_scan_user(void) {

uint8_t layer = biton32(layer_state);

ergodox_board_led_off();
ergodox_right_led_1_off();
ergodox_right_led_2_off();
ergodox_right_led_3_off();
switch (layer) {

<#list layout.layers?keys as layer>
    <#if layout.layers[layer].hasLED()>
    case ${layer}:
        <#if layout.layers[layer].led1>ergodox_right_led_1_on();</#if>
        <#if layout.layers[layer].led2>ergodox_right_led_2_on();</#if>
        <#if layout.layers[layer].led3>ergodox_right_led_3_on();</#if>
    break;
    </#if>
</#list>
default:
// none
break;
}

};

