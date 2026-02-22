#!/bin/bash
cp -r src/main tmp
cd tmp
javac -source 11 -target 11 model/*.java
jar cMf CoinCollection.jar model/*.class
cd ..
mv tmp/CoinCollection.jar tests/correct/CoinCollection.jar
rm -r tmp

