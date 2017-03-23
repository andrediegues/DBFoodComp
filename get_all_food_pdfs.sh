#!/bin/bash

for i in  `seq 1 1132`;
do
    curl --cookie-jar "/home/andre/shitcookie" --cookie "/home/andre/shitcookie"  -O https://insa.foodcase.ch/foodcomp/pdf?$i -k
    pdftotext -layout pdf?$i
    rm -f pdf\?$i
done

exit($?)
