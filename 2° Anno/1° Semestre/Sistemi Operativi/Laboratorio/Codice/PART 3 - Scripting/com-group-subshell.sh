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

echo "Subshell process after the while [ 1 ] ..."

)
# This script wait "here" for the subshell process...
# Thus, it will run forever, or at least:
# -- until it is terminated by a Ctrl-C
# -- until its subshell process is killed

echo
echo "Finally, I got here... I can now exit!"
echo

exit $?  # End of script
