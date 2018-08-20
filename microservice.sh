#!/bin/sh

BASE_PATH=`pwd`

i=0
for dir in `ls -d *microservice*/`
do
   dirlist[$i]=$dir
   result=`sed '$d' $BASE_PATH/$dir/.gitignore`
   rm -rf .gitignore
   echo "$result" > $BASE_PATH/$dir/.gitignore
   echo "$dir end\n"
   ((i++))
done

echo ${dirlist[*]}
