#!/bin/bash

ip1p1=$( echo $1 | cut -d"." -f1 )
ip1p2=$( echo $1 | cut -d"." -f2 )
ip1p3=$( echo $1 | cut -d"." -f3 )
ip1p4=$( echo $1 | cut -d"." -f4 )
ip2p1=$( echo $2 | cut -d"." -f1 )
ip2p2=$( echo $2 | cut -d"." -f2 )
ip2p3=$( echo $2 | cut -d"." -f3 )
ip2p4=$( echo $2 | cut -d"." -f4 )

for ((a = $ip1p1; a <= $ip2p1; a++))
do
	for ((b = $ip1p2; b <= $ip2p2; b++))
	do
		for ((c = $ip1p3; c <= $ip2p3; c++))
		do
			for ((d = $ip1p4; d <= $ip2p4; d++))
			do
				echo "$a.$b.$c.$d"
			done
		done
	done
done
