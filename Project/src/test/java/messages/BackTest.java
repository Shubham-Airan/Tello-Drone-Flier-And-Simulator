package messages;

import common.Communicator;
import org.junit.Test;

import java.net.DatagramSocket;
import java.net.InetAddress;

import static org.junit.Assert.*;

public class BackTest {

    @Test
    public void doAction() throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket();
        Back back=new Back();
        int maxRetries=3;
        Communicator communicator=new Communicator(8889, InetAddress.getByName("127.0.0.1"),datagramSocket);
        String backVal="50";
        String reply=back.sendMessage(communicator,"back "+backVal,maxRetries);
        assertEquals("nothing received",reply);


    }
}