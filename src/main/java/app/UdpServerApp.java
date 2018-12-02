package app;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.lang.model.util.ElementScanner6;

public class UdpServerApp {
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

        byte[] result;
        result = SampleMsgs.javaServerPerson.toByteArray();
        // System.out.println("js: " +  Integer.toString(result.length));

        // result = SampleMsgs.javaClientPerson.toByteArray();
        // System.out.println("jc: " +  Integer.toString(result.length));

        // result = SampleMsgs.pythonClientPerson.toByteArray();
        // System.out.println("pc: " +  Integer.toString(result.length));

        // result = SampleMsgs.pythonServerPerson.toByteArray();
        // System.out.println("ps: " +  Integer.toString(result.length));

        //Create a socket
        DatagramSocket socket = new DatagramSocket(port);

        // Create a packet

        DatagramPacket packet;

        result = SampleMsgs.javaClientPerson.toByteArray();
        byte[] data = new byte[result.length]; // Max length

        while(true)
        {
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

                    //Send reply
                    result = SampleMsgs.javaServerPerson.toByteArray();
                    packet = new DatagramPacket(data, result.length, clientAddr, clientPort);
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