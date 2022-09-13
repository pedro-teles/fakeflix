#!/bin/bash
BASEDIR=$(dirname "$0")

cd $BASEDIR/../services

git clone git@github.com:pedro-teles/diplomat-architecture-template.git $1

mv $1/src/diplomat_architecture_template $1/src/$1
mv $1/test/diplomat_architecture_template $1/test/$1

find $1 -type f -exec sed -i "s/diplomat-architecture-template/$1/g" {} \;
find $1 -type f -exec sed -i "s/template/$1/g" {} \;

rm -rf $1/.git
