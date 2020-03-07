#!/bin/bash
nb_test=$1
if [ -z "$nb_test" ]
then
	echo "usage: ./script nb_test
       ./script [ -h | -c ]

	-h Help page

	-c Clean generated files / folders

testfiles should be like input{x}.txt and output{x}.txt starting from 0. see example below:
	src/
		Project/
			file.java
			file_.java
	test/
		run.sh
		testFiles/
			input0.txt
			input1.txt
			output0.txt
			output1.txt"
	exit 1	
elif [ "$nb_test" == "-h" ]
then
	echo "This scipt is a generic script to test Java Packages.
	IMPORTANT, it is recommended to save your work as this script uses cp/mv/rm/mkdir and \"echo > files\"
	this script will:
		1. compile.
		2. execute and compare with given input/output pairs.
		3. create a report file with each test.
		4. create a diff file \"resultX.txt\" for each unsuccessful test, if any.
		5. Clean any compilation file, or useless files (class files, files with OK test...)

How to:
	/!\ For this to work, execute the command with no arguments or read the following:
	
	-next to the  \"src\" folder that contains the \".java\" files, create a new \"test/\" folder
	-put this binaty (.sh) in the test folder
	-create a \"testFiles\" folder that contains the various input/output files
	-input/output files shall be named: inputX.txt, and outputX.txt, X being the test #.
	
	for mor information run this scriptt with no parameters"
	exit 1
elif [ "$nb_test" == "-c" ]
then
	rm -fr resultList/ testReport
fi

#ADAPT PATH HERE
cd ~/work/CSULB/CECS328/CECS-Excavation/test 
rm -fr src/ resultList/ testReport.txt 
mkdir src resultList
cp ../src/Excavation/*.java ./src
echo "------------------------------------ starts compile ------------------------------------"

javac -d . ./src/*.java

echo "------------------------------------ finish compile ------------------------------------"

inputList={testFiles/input.txt}

for ((i=0; i<=$nb_test; i++))
do
	echo "------------------------------------ testt $i starts ------------------------------------"
	cp ./testfiles/input$i.txt ./input.txt
	java Excavation.Excavation
	diff output.txt testFiles/output$i.txt
	r=$?
	if [ $r -eq 0 ]
	then
		echo "input $i > OK." >> testReport.txt
	elif [ $r -eq 1 ]
	then
		echo "input $i > KO." >> testReport.txt
		diff output.txt testFiles/output$i.txt > resultList/result$i.txt
	else
		echo "input $i > diff Fail." >> testReport.txt
	fi
	cat output.txt 
	cat testfiles/output$i.txt
	echo "------------------------------------ test $i finish ------------------------------------"
	echo ""
done


rm -fr output.txt src Excavation input.txt
cat testReport.txt
