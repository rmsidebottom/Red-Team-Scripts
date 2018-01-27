#!/usr/local/bin/python
from scapy.all import *

# send ICMP ECHO request to ip
# ip: the IP address of a potential host
# return: true of false pending on response from remote host
def icmpEcho(ip):
    packet = IP(dst=ip)/ICMP(type=8)
    ans = sr1(packet, timeout=2, verbose=0)

    if ans is None:
        return False
    elif (ans.getlayer(ICMP).type==3 and
        ans.getlayer(ICMP).code in [1,2,3,9,10,13]):
        return False
    else:
        return True

# send TCP SYN to port 443 on ip
# ip: the IP address of a potential host
# return: true of false pending on response from remote host
def tcpSYN(ip):
    # system that is up returns RST, ACK
    # linux sends ICMP destination unreachable when firewall on
    packet = IP(dst=ip)/TCP(sport=5000, dport=80, flags="S")
    ans = sr1(packet, timeout=2, verbose=0)

    if ans is None:
        return False
    elif (ans.getlayer(TCP).flags=="20"):
        return True
    else:
        return False
    return

# send TCP ACK to port 80 on ip
# ip: the IP address of a potential host
# return: true of false pending on response from remote host
def tcpACK(ip):
    # receives an RST back
    # linux sends ICMP destination unreachable when firewall on
    return

# send ICMP Timestamp request to ip
# this is not possible for IPv6
# ip: the IP address of a potential host
# return: true of false pending on response from remote host
def icmpTimestamp(ip):
    packet = IP(dst=ip)/ICMP(type=13)
    ans = sr1(packet)

    if ans is None:
        return False
    elif (ans.getlayer(ICMP).type==3 and
        ans.getlayer(ICMP).code in [1,2,3,9,10,13]):
        return False
    else:
        return True


    return

def main():
    return

if __name__ == "__main__":
    main()
