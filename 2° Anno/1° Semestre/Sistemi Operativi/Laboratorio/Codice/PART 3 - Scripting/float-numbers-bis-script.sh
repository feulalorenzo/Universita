#!/bin/bash
# Arithmetic with float numbers
# Marco A. dd/mm/yyyy
echo

echo 1.1 + 2.2 | bc -l

echo 1.1 - 2.2 | bc -l

# This is wrong!
# echo 1.1 * 2.2 | bc -l

# This is right!
echo 1.1 \* 2.2 | bc -l

# This is right!
echo '1.1 * 2.23546738' | bc -l

echo '1.1 / 2.2' | bc -l

myvar=`echo '1.1 / 2.1' | bc -l`
echo $myvar

echo $[1 + 2]

echo $( (2^8) )

echo $((2^8))

echo $((2**8))