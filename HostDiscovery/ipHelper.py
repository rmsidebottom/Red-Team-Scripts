#!/usr/local/bin/python
import sys, socket, struct
from netaddr import *
# need to install netaddr, pip install netaddr
# ./ipHelper.py ipStart ipEnd
# ./ipHelper.py ipCidr
# writes output to ipList.txt

def genIPList(start, end):
    start = struct.unpack('>I', socket.inet_aton(start))[0]
    end = struct.unpack('>I', socket.inet_aton(end))[0]
    return [socket.inet_ntoa(struct.pack('>I', i)) for i in range(start, end)]

def main():
    if len(sys.argv) > 2:
	# means we have range
	ip = genIPList(sys.argv[1], sys.argv[2])
    else:
	# means we have cidr
	ip = IPNetwork(sys.argv[1])

    f = open("ipList.txt", "w")
    for addr in ip:
        f.write(str(addr) + '\n')
    f.close()

if __name__ == "__main__":
	main()

# cidr: https://stackoverflow.com/questions/17641203/how-can-i-generate-all-possible-ips-from-a-cidr-list-in-python
# ip range: https://stackoverflow.com/questions/17641492/how-can-i-generate-all-possible-ips-from-a-list-of-ip-ranges-in-python
