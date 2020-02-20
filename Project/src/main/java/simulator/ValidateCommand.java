package simulator;
import common.*;
import messages.*;

public class ValidateCommand extends Thread
{
    Communicator simulatorStatusCommunicator;
        public void replyFlier(String command,Communicator communicateServer) throws Exception{
         if (command.equals("received command from different port"))
            {
                System.out.println(command);
            }
            else if (command.equals("received command from different address"))
            {
                System.out.println(command);
            }
            else if(command.equals(TelloCommands.CommandsMap.get("COMMAND_MODE")))
            {
                communicateServer.send("ok");
                SimulatorStatusUpdate.droneState.setInCommandMode(true);
            }
            else if (!SimulatorStatusUpdate.droneState.isInCommandMode() && (!command.equals(TelloCommands.CommandsMap.get("COMMAND_MODE"))))
            {
                communicateServer.send("Can not process, not in command mode");
            }
            else if(command.equals(TelloCommands.CommandsMap.get("TAKE_OFF")))
            {
                communicateServer.send("ok");
                SimulatorStatusUpdate.droneState.setHasTakenOff(true);
            }
            else if(command.equals(TelloCommands.CommandsMap.get("Land")) && SimulatorStatusUpdate.droneState.hasTakenOff())
            {
                communicateServer.send("ok");
                SimulatorStatusUpdate.droneState.resetState();
            }
            else{
                ValidateParameter validationObject = new ValidateParameter(command);
                boolean IsValidCommand = validationObject.validateCommand();
                if (!IsValidCommand)
                {
                    communicateServer.send("unrecognized message");
                }
                else
                {
                    validationObject.validParameter(communicateServer, SimulatorStatusUpdate.droneState );
                }
            }
}
}