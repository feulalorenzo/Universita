#!/bin/bash
# This is the first script for reading input
# Marco A. dd/mm/yyyy

echo
echo What\'s your name?
read varname
echo
echo Hi $varname !!
echo

read -p 'What is your nikname?  ' nicknamevar

read -sp 'What is your password?  ' passvar
echo
echo $nicknamevar

echo "My password is $passvar"
echo
echo "$nicknamevar ... You should never print the password!!!" 

echo
echo Ciao ciao... See you next time!
echo
