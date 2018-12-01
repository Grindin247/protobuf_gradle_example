import socket
import time
import sys

import addressbook_pb2

def flush_out(string, *arg):
    print(string.format(arg))
    sys.stdout.flush()

person = addressbook_pb2.Person()
person.id = 1234
person.name = "From Python"
person.email = "python@example.com"
phone = person.phones.add()
phone.number = "555-4321"
phone.type = addressbook_pb2.Person.HOME

UDP_IP = "192.168.0.3"
UDP_PORT = 8000
MESSAGE = "Hello, World!".encode('utf-8')

flush_out ("UDP target IP:", UDP_IP)
flush_out ("UDP target port:", UDP_PORT)
flush_out ("message:", MESSAGE)


sock = socket.socket(socket.AF_INET, # Internet
             socket.SOCK_DGRAM) # UDP
while True:
    sock.sendto(person.SerializeToString(), (UDP_IP, UDP_PORT))
    time.sleep(0.1)
    flush_out('SENT!')