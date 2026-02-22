#!/bin/bash
className='CoinCollection'
for file in src/main/model/buggy/CoinCollectionBuggy*; do
  cp -r src/main tmp
  bugName=$(basename $file .java)
  cp $file "tmp/model/${className}.java"
  sed -i '' -e "s/${bugName}/${className}/g" "tmp/model/${className}.java"
  sed -i '' -e 's/model\.buggy/model/g' "tmp/model/${className}.java"
  cd tmp
  rm -r model/buggy
  javac -source 11 -target 11 model/*.java
  jar cMf $bugName.jar model/*.class
  mv $bugName.jar ../tests/buggy/$bugName.jar
  cd ..
  rm -r tmp
done
