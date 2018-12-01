package app;

public class App {
    public static void main(String[] args) throws Exception {

        AddressBookProtos.Person.Builder person = AddressBookProtos.Person.newBuilder();
        person.setId(1);
        person.setName("Jane Smith");
        person.setEmail("jsmith@bitbuckets.org");

        AddressBookProtos.Person temp = person.build();


        AddressBookProtos.Person john =
        AddressBookProtos.Person.newBuilder()
            .setId(1234)
            .setName("John Doe")
            .setEmail("jdoe@example.com")
            .addPhones(
                AddressBookProtos.Person.PhoneNumber.newBuilder()
                .setNumber("555-4321")
                .setType(AddressBookProtos.Person.PhoneType.HOME))
            .build();

        System.out.println("Hello World");

    }
}