package common;

import org.junit.Test;

import java.net.DatagramSocket;
import java.net.InetAddress;

import static org.junit.Assert.*;

public class CommunicatorTest {

    @Test
    public void constructorTestwithNullSocket() throws Exception{
        DatagramSocket udpClient= new DatagramSocket();
        Communicator communicator = new Communicator(8889, InetAddress.getByName("127.0.0.1"),udpClient);
        Communicator communicator1= new Communicator(udpClient);
        assertEquals(8889, communicator.destinationPort);
        assertEquals(InetAddress.getByName("127.0.0.1"), communicator.destinationAddress);
//        assertEquals(udpClient,communicator.getDatagramSocket());
//        assertEquals(udpClient,communicator1.getDatagramSocket());
    }

    @Test
    public void send() {
    }

    @Test
    public void receive() throws Exception{
        String expectedReply="ok";
        DatagramSocket udpClient= new DatagramSocket();
        Communicator communicator2 = new Communicator(8889,InetAddress.getByName("127.0.0.1"),udpClient);
        communicator2.send("command");
        communicator2.receive().compareTo(expectedReply);

    }
}