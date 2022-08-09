#!/bin/bash
BASEDIR=$(dirname "$0")

cd $BASEDIR/../services

for file in *
do
	if [ -d $file ]
	then
	      	cd $file
		
		echo "Checking lint  on project $file"

		lein lint

		if [ $? != 0 ]
		then
			exit 1
		fi
		
		cd ..
	fi
done
