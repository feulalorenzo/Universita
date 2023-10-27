#!/bin/bash
# This is the first script on commands grouping
# by using the parentheses operators {}
# Marco A. dd/mm/yyyy

{
# Commands group inside parentheses {}, and therefore NO subshell process ...
while [ 1 ]   # Endless loop.
do
    sleep 1
    echo "Subshell running ..."
done
}
# No subshell has been created...

echo
echo "I will never got here... I cannot exit!"
echo "Please, terminate me with Ctrl-C or kill me :("
echo

exit $?  # End of script
