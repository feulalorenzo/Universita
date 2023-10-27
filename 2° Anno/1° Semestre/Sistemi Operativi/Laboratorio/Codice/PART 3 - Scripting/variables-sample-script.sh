#!/bin/bash
# This is the first script about variables
# Marco A. dd/mm/yyyy

echo
echo Let\'s play with variables...
echo The name of this script is: \"$0\"
echo The first argument passed to this script is: \"$1\"
echo The second argument passed to this script is: \"$2\"
echo

p1from30to39=`egrep '3.?' $1`
p2from30to39=`egrep '3.?' $2`

echo Persons from 30 to 39 years old in \"$1\": $p1from30to39
echo Persons from 30 to 39 years old in \"$2\": $p2from30to39

echo
echo Ciao ciao... See you next time!
echo
