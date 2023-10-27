#!/bin/bash
# Arithmetic expression with expr
# Marco A. 24/10/2016

echo

# Spaces must be used
expr 5 + 4

expr 5+ 4
expr 5 + 4
expr "5 + 4"

# The tiimes operator "*"" must be escaped
expr 5 \* 12

expr 5 * 12

expr $1 + 1000

echo a=$(expr $1 + 2000)
echo a=$( expr $1 + 2000 )

echo
echo Ciao ciao... See you next time!
echo
