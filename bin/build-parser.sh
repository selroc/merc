#!/bin/bash

cd src/edu/vtc/merc
java -Xmx2048M -cp ../../../../lib/antlr4-4.5.3.jar org.antlr.v4.Tool -visitor Merc.g4
cd ../../../..

