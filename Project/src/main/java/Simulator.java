import java.net.DatagramSocket;

import messages.*;
import common.*;
import simulator.*;
class Simulator {

    public static void main(String[] args) throws Exception {

        TelloCommands t = new TelloCommands();
        DatagramSocket udpServer = new DatagramSocket(8889);
        Communicator communicateServer = new Communicator(udpServer);

        String command;
        command = communicateServer.receive();
        System.out.println(command+" received");

        ValidateCommand validateCommand = new ValidateCommand();
        validateCommand.replyFlier(command,communicateServer);

        SimulatorStatusUpdate simulatorStatusUpdate =new SimulatorStatusUpdate();
        if(SimulatorStatusUpdate.droneState.isInCommandMode())
        {
            simulatorStatusUpdate.start();
        }

        while (true) {
            command = communicateServer.receive();
            System.out.println(command+" received");
            validateCommand.replyFlier(command,communicateServer);

        }
    }
}