#!/bin/bash

cd $1

echo "package de.caluga.ergodox;"
echo
echo "public enum ErgodoxKeyCode {"

grep "#define" ./quantum/keymap_common.h | cut -f 2 -d' '| grep -v ')'| grep -v '(' | sed -e 's/$/,/' >> /tmp/$$.tmp
grep KC_ ./tmk_core/common/keycode.h | grep -v '#define'|tr -d ' '|tr =/ ,,|cut -f1 -d, |sed -e 's/$/,/' >> /tmp/$$.tmp
grep '#define' ./quantum/keymap_extras/keymap_*.h | cut -f2- -d: |sed -e 's/#define//' | sed -e 's/^ //'| cut -f1 -d' '| cut -f1 | sed -e 's/$/,/'| sed -e 's/,,/,/' | egrep -v '^,$' | sort -u >> /tmp/$$.tmp
grep "#define" ./tmk_core/common/keycode.h | grep -v '(' | cut -f 2 -d' ' | sed -e 's/$/,/'|sed -e 's/,,/,/' | egrep -v '^,$' | sort -u | grep -v '(' | grep -v 'KEYMAP' >> /tmp/$$.tmp 

sort -u /tmp/$$.tmp | grep -v ')' | grep -v '('
rm -f /tmp/$$.tmp
echo "}"
