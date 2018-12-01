package app;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpServerApp {
    public static void main(String[] args) throws Exception {

        String host = "192.168.0.3";
        int port = 8000;

        //Create a socket
        DatagramSocket socket = new DatagramSocket(port);

        // Create a packet

        DatagramPacket packet;

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

            byte[] result;
            result = john.toByteArray();
            byte[] data = new byte[result.length]; // Max length

        while(true)
        {
            System.out.println("Hit Here");
            try {
                    // Recieve messages
                    packet = new DatagramPacket(data, result.length);
                    socket.receive(packet);

                    AddressBookProtos.Person p = AddressBookProtos.Person.parseFrom(packet.getData());
                    System.out.println(p.getName());
                    System.out.println(p.getId());
                    System.out.println(p.getEmail());
                    int clientPort = packet.getPort();
                    InetAddress clientAddr = packet.getAddress();
                    Thread.sleep(100);

                    result = john.toByteArray();
                    packet = new DatagramPacket(data, data.length, clientAddr, clientPort);
                    packet.setData(result);
                    socket.send(packet);
        
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