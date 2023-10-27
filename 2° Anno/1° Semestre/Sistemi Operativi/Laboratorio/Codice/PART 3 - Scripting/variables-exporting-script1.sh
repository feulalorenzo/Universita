#!/bin/bash
# Script to set the environment variable PATH when needed
# Marco A. dd/mm/yyyy

export NEW_LOCATION=/usr/local/mynewbin
echo $NEW_LOCATION
export PATH=$PATH:$NEW_LOCATION
echo The content of the variable PATH is: $PATH

