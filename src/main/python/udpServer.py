import argparse
import socket
import time
import sys

import addressbook_pb2

from sampleMsgs import pythonClientPerson, pythonServerPerson, javaServerPerson

def flush_out(string):
    print(string)
    sys.stdout.flush()

parser = argparse.ArgumentParser(description='Network Params')
ConnectionInfo = argparse.ArgumentParser()
ConnectionInfo.add_argument("-n",  default='192.168.0.3')#ConnectionInfo.add_argument("-n",  default=socket.gethostname())
ConnectionInfo.add_argument("-p", type=int, default='8000')
ConnectionInfoParsed = ConnectionInfo.parse_args()

# Saves the parsed IP and Port
UDP_IP = ConnectionInfoParsed.n
UDP_PORT = ConnectionInfoParsed.p

MESSAGE = person.SerializeToString()

flush_out ("UDP target IP: {0}".format(UDP_IP))
flush_out ("UDP target port: {0}".format(UDP_PORT))


sock = socket.socket(socket.AF_INET, # Internet
socket.SOCK_DGRAM) # UDP
sock.bind(('', UDP_PORT))
while True:
    data = sock.recvfrom(62)
    p = addressbook_pb2.Person()
    p.ParseFromString(data)
    flush_out(p.getName())
    flush_out(p.getId())
    flush_out(p.getEmail())

    #TODO: Get client IP and send out python server messageffff
    time.sleep(0.1)
    flush_out(MESSAGE)
    flush_out (str(len(MESSAGE)))