# Port Scanner


### These applications will scan the ports of any number of hosts. The ports to be scanned may also be specified.

## portScan.sh

This file is run by entering *./portScan.sh ipRange portRange*
+ ipRange can be a.b.c.d-e.f.g.h or a.b.c.d/Y
+ portRange can be a,b,c or x-y

ipRange.sh and ipCIDR.sh are purely helper scripts in this case as they translate the range of IP addresses into a list of IP addresses.

Should you wish to run either of them on their own, run:
+ *./ipRange.sh start end*
+ *./ipCIDR.sh address/CIDR*

Note, *address/CIDR* is normal CIDR notation. Also, both of these will write the IP list to stdout if not redirected into a file.
