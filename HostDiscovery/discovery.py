#!/usr/local/bin/python
from scapy.all import *

# send ICMP ECHO request to ip
# ip: the IP address of a potential host
# return: true of false pending on response from remote host
def icmpEcho(ip):
    packet = IP(dst=ip)/ICMP(type=8)
    ans = sr1(packet)
    return

# send TCP SYN to port 443 on ip
# ip: the IP address of a potential host
# return: true of false pending on response from remote host
def tcpSYN(ip):
    return

# send TCP ACK to port 80 on ip
# ip: the IP address of a potential host
# return: true of false pending on response from remote host
def tcpACK(ip):
    return

# send ICMP Timestamp request to ip
# this is not possible for IPv6
# ip: the IP address of a potential host
# return: true of false pending on response from remote host
def icmpTimestamp(ip):
    packet = IP(dst=ip)/ICMP(type=13)
    ans = sr1(packet)
    return

def main():
    return

if __name__ == "__main__":
    main()
