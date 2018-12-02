import addressbook_pb2

pythonServerPerson = addressbook_pb2.Person()
pythonServerPerson.id = 1
pythonServerPerson.name = "From Python Server"
pythonServerPerson.email = "pythonserver@example.com"
phone = pythonServerPerson.phones.add()
phone.number = "555-4321"
phone.type = addressbook_pb2.Person.HOME

pythonClientPerson = addressbook_pb2.Person()
pythonClientPerson.id = 2
pythonClientPerson.name = "From Python Client"
pythonClientPerson.email = "pythonclient@example.com"
phone = pythonClientPerson.phones.add()
phone.number = "555-4321"
phone.type = addressbook_pb2.Person.HOME

javaServerPerson = addressbook_pb2.Person()
javaServerPerson.id = 3
javaServerPerson.name = "From Java Server"
javaServerPerson.email = "javaserver@example.com"
phone = javaServerPerson.phones.add()
phone.number = "555-4321"
phone.type = addressbook_pb2.Person.HOME

javaClientPerson = addressbook_pb2.Person()
javaClientPerson.id = 4
javaClientPerson.name = "From Java Client"
javaClientPerson.email = "javaclient@example.com"
phone = javaClientPerson.phones.add()
phone.number = "555-4321"
phone.type = addressbook_pb2.Person.HOME