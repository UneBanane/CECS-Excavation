#!/bin/bash
cp ../src/Excavation/*java .
cp 
javac *.java

java Excavation testFiles/input.txt
diff output.txt testFiles/output.txt 2>&1
retVal = $?
if [ $error -eq 0 ]
then
	echo "input 0 > OK."
elif [ $error -eq 1 ]
then
	echo "input 0 > KO. "
	diff output.txt testFiles/output.txt > result0.txt
else
	echo "input 0 > diff Fail."
fi


java Excavation testFiles/input-1.txt
diff output.txt testFiles/output-1.txt > result1.txt

java Excavation testFiles/input-2.txt
diff output.txt testFiles/output-2.txt > result2.txt

java Excavation testFiles/input-3.txt
diff output.txt testFiles/output-3.txt > result3.txt

java Excavation testFiles/input-4.txt
diff output.txt testFiles/output-5.txt > result4.txt

java Excavation $1 $2
