#!/bin/bash
# This is the first script on commands grouping
# by using the parentheses operators ()
# Marco A. dd/mm/yyyy

(
# Commands group inside parentheses, and therefore a subshell process ...
while [ 1 ]   # Endless loop.
do
    sleep 1
    echo "Subshell running ..."
done
) &
# This script DOES NOT wait "here" for the subshell process...

i=0
while [ $i -lt 4 ]   # Endless loop.
do
    sleep 1
    echo "Parent script running - Cycle number: $i "
    ((i++))
done

echo
echo "I completed my job... I can now exit!"
echo

exit $?  # End of script
