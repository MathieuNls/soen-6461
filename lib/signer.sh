#!/bin/bash
FILES=*
for f in $FILES
do
  echo "Processing $f file..."
  jarsigner -keystore Devils -keypass azerty -storepass azerty $f Devils;
done