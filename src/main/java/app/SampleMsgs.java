package app;

public class SampleMsgs {
    public static AddressBookProtos.Person pythonServerPerson =
    AddressBookProtos.Person.newBuilder()
        .setId(1)
        .setName("From Python Server")
        .setEmail("pythonserver@example.com")
        .addPhones(
            AddressBookProtos.Person.PhoneNumber.newBuilder()
            .setNumber("555-4321")
            .setType(AddressBookProtos.Person.PhoneType.HOME))
        .build();

    public static AddressBookProtos.Person pythonClientPerson =
    AddressBookProtos.Person.newBuilder()
        .setId(2)
        .setName("From Pyhton Client")
        .setEmail("pythonclient@example.com")
        .addPhones(
            AddressBookProtos.Person.PhoneNumber.newBuilder()
            .setNumber("555-4321")
            .setType(AddressBookProtos.Person.PhoneType.HOME))
        .build();

    public static AddressBookProtos.Person javaServerPerson =
    AddressBookProtos.Person.newBuilder()
        .setId(3)
        .setName("From Java Server")
        .setEmail("javaserver@example.com")
        .addPhones(
            AddressBookProtos.Person.PhoneNumber.newBuilder()
            .setNumber("555-4321")
            .setType(AddressBookProtos.Person.PhoneType.HOME))
        .build();

    public static AddressBookProtos.Person javaClientPerson =
    AddressBookProtos.Person.newBuilder()
        .setId(4)
        .setName("From Java Client")
        .setEmail("javaclient@example.com")
        .addPhones(
            AddressBookProtos.Person.PhoneNumber.newBuilder()
            .setNumber("555-4321")
            .setType(AddressBookProtos.Person.PhoneType.HOME))
        .build();

}
