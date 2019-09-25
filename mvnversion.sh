#!/usr/bin/env bash
if [ -z "$1" ]
	then
	echo "Please insert your version..."
else
	mvn -N versions:set -DnewVersion=$1

	cd itf-chartizate-java
	mvn -N versions:set -DnewVersion=$1
	cd ..
fi

