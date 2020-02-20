import common.*;
import flier.*;
import messages.*;
import java.util.Scanner;
import java.net.*;
import java.lang.*;

public class Main {
        public static void main(String[] args) throws Exception
			{	
			Scanner in = new Scanner(System.in);
               int maxRetries;

            DatagramSocket udpClient=new DatagramSocket();
			InetAddress droneAddress;

			int dronePort,missionOption,socketTimeout;

            System.out.println("Please enter IP address of drone");
			droneAddress = InetAddress.getByName(in. nextLine());
			
			System.out.println("Please enter port number of drone");
			dronePort = in.nextInt();
            in.nextLine();

            System.out.println("Please enter socket timeout of our port, which will communicate to drone");
            socketTimeout = in.nextInt();
            in.nextLine();


            udpClient.setSoTimeout(socketTimeout);

            System.out.println("Please enter maximum retries, we should do to communicate Drone");
            maxRetries = in.nextInt();
            in.nextLine();


            System.out.println("Please enter mission number");
            missionOption = in.nextInt();
            in.nextLine();

            System.out.println("Please enter path of log file");
            String logFile = in.nextLine();

            TelloCommands t = new TelloCommands();

            FlierStatusUpdate flierStatusUpdate =new FlierStatusUpdate(logFile);
            flierStatusUpdate.start();

            Communicator communicatorMission = new Communicator(dronePort,droneAddress,udpClient);
            Flier flySelect = new Flier();
            flySelect.flying(missionOption, communicatorMission,maxRetries);



}
}