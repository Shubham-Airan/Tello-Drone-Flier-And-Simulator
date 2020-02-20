package messages;

import common.Communicator;
import org.junit.Test;

import java.net.DatagramSocket;
import java.net.InetAddress;

import static org.junit.Assert.*;

public class MessagesTest {

    @Test
    public void sendMessage() throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket();
        Communicator communicator=new Communicator(8889, InetAddress.getByName("127.0.0.1"),datagramSocket);
        String message="command";
        communicator.send(message);
        String reply=communicator.receive();
        assertEquals("ok",reply);
    }
}