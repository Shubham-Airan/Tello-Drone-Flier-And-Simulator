package common;

import java.net.*;
import java.nio.charset.StandardCharsets;
import java.lang.*;

public class Communicator
{
		   	int destinationPort=0;
			InetAddress destinationAddress=null;

			 DatagramSocket socket;
			private DatagramPacket datagramPacket;

		  public Communicator(DatagramSocket socket) throws Exception{
			   this.socket = socket;

		   }

		  public Communicator(int destinationPort, InetAddress destinationAddress, DatagramSocket socket) throws Exception  {
				   this.destinationPort = destinationPort;
				   this.destinationAddress =InetAddress.getByName(destinationAddress.getHostAddress());
				   this.socket = socket;
		   }

//		    //public int getDestinationPort(){
//		   	return destinationPort;
//}
//
//			//public InetAddress getDestinationAddress(){
//		   	return destinationAddress;
//}

    		public void send (String request) throws Exception {
                    byte[] bytesToSent;
                    bytesToSent = request.getBytes(StandardCharsets.UTF_8);
                    datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, destinationAddress, destinationPort);

                    socket.send(datagramPacket);

				if(datagramPacket.getPort()!=8890) {
					System.out.println("Sent " + request + " bytes to " + destinationAddress.toString() + ":" + destinationPort);
				}}

				 public String receive() throws Exception
                {
					String reply = null;
					byte[] bytesReceived;
				 bytesReceived = new byte[150];
				 datagramPacket = new DatagramPacket(bytesReceived, 150);

				 try {
					 socket.receive(datagramPacket);
					 }
				 catch (SocketTimeoutException ex) {
					 datagramPacket = null;
						}
					if(destinationAddress==null){destinationAddress=datagramPacket.getAddress();}
					if(destinationPort==0){destinationPort=datagramPacket.getPort();}

					if (datagramPacket != null)
					 {
					 reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
					 if((destinationPort==8889) || (datagramPacket.getPort()==8889))
					 { System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
					 System.out.println("Receive " + reply);}
					 Thread.sleep(1000);
					 }

				 if (reply == null)
				 	return "Nothing received";

				 else
				 	return reply;
				 }
			 }