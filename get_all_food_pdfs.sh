#!/bin/bash

for i in  `seq 1 1132`;
do
    curl --cookie-jar "/home/andre/ptcookie" --cookie "/home/andre/ptcookie"  -O https://insa.foodcase.ch/foodcomp/pdf?$i -k
    pdftotext -layout pdf?$i
    rm -f pdf\?$i
done

exit($?)
