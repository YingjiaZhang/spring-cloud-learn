#!/bin/sh

BASE_PATH=`pwd`

i=0
for dir in `ls -d *microservice*/`
do
   dirlist[$i]=$dir
   result=`cp -a $BASE_PATH/.mvn/ $BASE_PATH/$dir/.mvnw/`
   echo "cp $dir end\n"
   ((i++))
done

echo ${dirlist[*]}
