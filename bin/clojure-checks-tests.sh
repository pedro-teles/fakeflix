#!/bin/bash
BASEDIR=$(dirname "$0")

cd $BASEDIR/../services

for file in *
do
	if [ -d $file ]
	then
	      	cd $file

		echo "Running Unit Tests on project $file"

		lein test
		
		if [ $? != 0 ]
		then
			exit 1
		fi
		
		cd ..
	fi
done
