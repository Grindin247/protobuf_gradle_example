package app;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

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
        packet.setPort(port)

        //Different ways to configure messages
        AddressBookProtos.Person.Builder person = AddressBookProtos.Person.newBuilder();
        person.setId(1);
        person.setName("Jane Smith");
        person.setEmail("jsmith@bitbuckets.org");

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
        while(true)
        {
            try {
                    // Send message
                    byte[] result = person.toByteArray() ;
                    packet.setData(result);
                    socket.send(packet);

                    Thread.sleep(500);

                    // Recieve messages
                    socket.receive(packet);
                    People p = People.parseFrom(packet.getData());
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