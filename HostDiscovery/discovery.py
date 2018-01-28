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

    # no answer = filtered by firewall
    # SA, RA = open

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
    packet = IP(dst=ip)/TCP(sport=5000, dport=80, flags="A")
    ans = sr1(packet, timeout=2, verbose=0)

    if ans is None:
        return False
    else:
        return True

    return

# send ICMP Timestamp request to ip
# this is not possible for IPv6
# ip: the IP address of a potential host
# return: true of false pending on response from remote host
def icmpTimestamp(ip):
    packet = IP(dst=ip)/ICMP(type=13)
    ans = sr1(packet, timeout=2, verbose=0)

    if ans is None:
        return False
    elif (ans.getlayer(ICMP).type==3 and
        ans.getlayer(ICMP).code in [1,2,3,9,10,13]):
        return False
    else:
        return True


    return

def main():
    count = 0
    ip = '127.0.0.1'
    if icmpEcho(ip):
        print '{} passed ICMP ECHO'.format(ip)
        count+=1
    if icmpTimestamp(ip):
        print '{} passed ICMP Timestamp'.format(ip)
        count+=1
    if tcpSYN(ip):
        print '{} passed TCP SYN'.format(ip)
        count+=1
    if tcpACK(ip):
        print '{} passed TCP ACK'.format(ip)
        count+=1
    print '{} passed {}/4 tests'.format(ip, count)
    return

if __name__ == "__main__":
    main()
