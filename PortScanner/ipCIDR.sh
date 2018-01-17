#!/bin/bash

p1=$( echo $1 | cut -d"." -f1 )
p2=$( echo $1 | cut -d"." -f2 )
p3=$( echo $1 | cut -d"." -f3 )
p4=$( echo $1 | cut -d"." -f4 )
cidr=$( echo $1 | cut -d"/" -f2 )

power=$(expr 32 - $cidr)
addrs=$(expr $((2**$power)) - 1)

if (($addrs <= 255))
then
	for ((a = $p4; a <= $addrs; a++))
	do
		echo "$p1.$p2.$p3.$a"
	done
elif (($addrs <= 65536))
then
	len=$(expr $power - 8)
	tot=$(expr $((2**$len)) - 1)
	echo $tot
	for ((a = $p3; a <= $tot; a++))
	do
		for ((b = $p4; b <= 255; b++))
		do
			echo "$p1.$p2.$a.$b"
		done
	done
elif (($addrs <= 16777216))	
then
	len=$(expr $power - 16)
	tot=$(expr $((2**$len)) - 1)
	for ((a = $p2; a <= $tot; a++))
	do
		for ((b = $p3; b <= 255; b++))
		do
			for ((c = $p4; c <= 255; c++))
			do
				echo "$p1.$a.$b.$c"
			done
		done
	done
elif (($addrs <= 16777216))	
then
	len=$(expr $power - 16)
	tot=$(expr $((2**$len)) - 1)
	for ((a = $p1; a <= $tot; a++))
	do
		for ((b = $p2; b <= 255; b++))
		do
			for ((c = $p3; c <= 255; c++))
			do
				for ((d = $p4l c <= 255; d++))
				do
					echo "$a.$b.$c.$d"
				done
			done
		done
	done
fi
