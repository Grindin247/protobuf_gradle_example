package app;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.lang.model.util.ElementScanner6;

public class UdpClientApp {
    public static void main(String[] args) throws Exception {
        String host = "";
        int port = 0;
        if(args.length == 2)
        {
            host = args[0];
            port = Integer.parseInt(args[1]);

        }
        else if (args.length == 1)
        {
            host = args[0];

        }
        else
        {
            host = "localhost";
            port = 8000;

        }

        System.out.println("Host: " + host);
        System.out.println("Port: " +  Integer.toString(port));

        //Create a socket
        DatagramSocket socket = new DatagramSocket(port);

        // Create a packet

        DatagramPacket packet;

        byte[] result;
        result = SampleMsgs.javaServerPerson.toByteArray();
        byte[] data = new byte[1024]; // Max length

        //int HEADER_LEN = 4;
        while(true)
        {
            try {
                    //Send message
                    result = SampleMsgs.javaClientPerson.toByteArray();
                    packet = new DatagramPacket(data, data.length, InetAddress.getByName(host), port);
                    packet.setData(result);
                    socket.send(packet);
                    Thread.sleep(100);

                    // Recieve message
                    packet = new DatagramPacket(data, result.length);
                    socket.receive(packet);

                    AddressBookProtos.Person p = AddressBookProtos.Person.parseFrom(packet.getData());
                    System.out.println(p.getId());
                    System.out.println(p.getName());
                    System.out.println(p.getEmail());

                    Thread.sleep(100);
        
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