import socket
import time
import sys

import addressbook_pb2

def flush_out(string):
    print(string)
    sys.stdout.flush()

person = addressbook_pb2.Person()
person.id = 1234
person.name = "From Python Client"
person.email = "pythonclient@example.com"
phone = person.phones.add()
phone.number = "555-4321"
phone.type = addressbook_pb2.Person.HOME

UDP_IP = "192.168.0.3"
UDP_PORT = 8000
MESSAGE = person.SerializeToString()

flush_out ("UDP target IP:".format(UDP_IP))
flush_out ("UDP target port:".format(UDP_PORT))
flush_out (MESSAGE)


sock = socket.socket(socket.AF_INET, # Internet
             socket.SOCK_DGRAM) # UDP
while True:
    data = sock.recv(50)
    addressbook_pb2.Person.ParseFromString(data)

    #TODO: Get client IP and send out python server messageffff
    time.sleep(0.1)
    flush_out(MESSAGE)
    flush_out (str(len(MESSAGE)))