#!/bin/bash
# Arithmetic with float numbers
# Marco A. dd/mm/yyyy
echo

#It doesn't work because bash doesn't support floating point
let var0=2.8+2.6
echo var0 = $var0

#It doesn't work because bash doesn't support floating point
let var1=2,8+2,6
echo var1 = $var1

# Using bc
var2=$(bc <<< "2.5+2.5")
echo var2 = $var2

# Using awk
var3=$(awk "BEGIN {print 2.5+2.5; exit}")
echo var3 = $var3

# Using perl
var4=$(perl -e "print 2.5+2.5")
echo var3 = $var4

# Using python
var5=$(python -c "print 2.5+2.5")
echo var5 = $var5
echo
