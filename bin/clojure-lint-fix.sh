#!/bin/bash
BASEDIR=$(dirname "$0")

cd $BASEDIR/../services

for file in *
do
	if [ -d $file ]
	then
	      	cd $file
		
		echo "Lint fix on project $file"

		lein lint-fix && lein lint-fix
		
		cd ..
	fi
done
