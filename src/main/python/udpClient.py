#Cleints sends data and receives server replies
import argparse
import socket
import time
import sys

import addressbook_pb2

from sampleMsgs import pythonClientPerson, pythonServerPerson, javaServerPerson

#TODO: gradle task workaround to see prints on the terminal
def flush_out(string):
    print(string)
    sys.stdout.flush()

parser = argparse.ArgumentParser(description='Network Params')
ConnectionInfo = argparse.ArgumentParser()
ConnectionInfo.add_argument("-n",  default='127.0.0.1')#ConnectionInfo.add_argument("-n",  default=socket.gethostname())
ConnectionInfo.add_argument("-p", type=int, default='8000')
ConnectionInfoParsed = ConnectionInfo.parse_args()

# Saves the parsed IP and Port
UDP_IP = ConnectionInfoParsed.n
UDP_PORT = ConnectionInfoParsed.p

flush_out ("UDP target IP: {0}".format(UDP_IP))
flush_out ("UDP target port: {0}".format(UDP_PORT))

sock = socket.socket(socket.AF_INET, # Internet
             socket.SOCK_DGRAM) # UDP
MESSAGE = pythonClientPerson.SerializeToString()
msgcnt = 0
while True:
    sock.sendto(MESSAGE, (UDP_IP, UDP_PORT))
    flush_out('Sent msg {0}'.format(msgcnt))
    time.sleep(0.1)
    msgcnt += 1

