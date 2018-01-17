#!/bin/bash
# ./portScan.sh ipRange portRange
# ipRange = x.x.x.x-x.x.x.x or x.x.x.x/Y
# portRange = x,c,v, b or x-y
#set -x
# get parameters
ipRange=$1
portRange=$2
ipFile="ipList.txt"

if [[ $ipRange == *"-"* ]]; then
	IFS='-' read -a ipArray <<< "${ipRange}"
	startIP=${ipArray[0]}
	endIP=${ipArray[1]}
	./ipRange.sh $startIP $endIP > $ipFile
else
	./ipCIDR.sh $ipRange > $ipFile
fi

if [[ $portRange == *"-"* ]]; then
	IFS='-' read -a portArray <<< "${portRange}"
	startPort=${portArray[0]}
	endPort=${portArray[1]}
	while read -r line
	do
		for port in $(seq $startPort $endPort);
		do	#connect
			(echo >/dev/tcp/$line/$port) > /dev/null 2>&1 && echo “$line:$port open”
		done
	done < "$ipFile"

else
	IFS=',' read -a portArray <<< "${portRange}"
	while read -r line
	do
		for port in ${portArray[@]}
		do	#connect
			(echo >/dev/tcp/$line/$port) > /dev/null 2>&1 && echo “$line:$port open”
		done
	done < "$ipFile"
fi
