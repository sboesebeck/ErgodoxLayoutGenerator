#!/bin/bash

cd $1

echo "package de.caluga.ergodox;"
echo
echo "public enum KeyCode {"
echo "   KC_TRNS,"
grep KC_ ./tmk_core/common/keycode.h | grep -v '#define'|tr -d ' '|tr =/ ,,|cut -f1 -d, |sed -e 's/$/,/'
grep KC_ ./quantum/keymap_extras/keymap_*.h | cut -f2- -d: |sed -e 's/#define//' | sed -e 's/^ //'| cut -f1 -d' '| cut -f1 | sed -e 's/$/,/'| sed -e 's/,,/,/' | egrep -v '^,$' | sort -u
echo "}"
