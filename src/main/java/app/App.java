package app;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class App {
    public static void main(String[] args) throws Exception {

        String host = "127.0.0.1";
        int port = 8000;

        //Create a socket
        DatagramSocket socket = new DatagramSocket();

        // Create a packet
        byte[] data = new byte[4096]; // Max length
        DatagramPacket packet = new DatagramPacket(data, data.length);
        packet.setAddress(InetAddress.getByName(host));
        packet.setPort(port);

        //Different ways to configure messages
        AddressBookProtos.Person.Builder personBuilder = AddressBookProtos.Person.newBuilder();
        personBuilder.setId(1);
        personBuilder.setName("Jane Smith");
        personBuilder.setEmail("jsmith@bitbuckets.org");

        AddressBookProtos.Person person = personBuilder.build();

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

        //UDP send/recv cycle
        byte[] result;
        while(true)
        {
            try {
                    // Send message
                    result = person.toByteArray();
                    packet.setData(result);
                    socket.send(packet);

                    Thread.sleep(100);

                    result = john.toByteArray();
                    packet.setData(result);
                    socket.send(packet);

                    Thread.sleep(100);

                    // Recieve messages
                    socket.receive(packet);
                    AddressBookProtos.Person p = AddressBookProtos.Person.parseFrom(packet.getData());
                    System.out.println(p.getName());
                    System.out.println(p.getId());
                    System.out.println(p.getEmail());
        
            } catch (UnknownHostException e){
                System.out.println("UnknownHostException:" + e.toString());
            } catch (java.io.IOException e) {
                System.out.println("IOException :" + e.toString());
                e.printStackTrace();
            }

            Thread.sleep(1000);
        }
    }
}