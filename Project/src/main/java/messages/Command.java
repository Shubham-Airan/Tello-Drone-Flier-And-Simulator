package messages;

import common.*;
import flier.FlierStatusUpdate;

public class Command extends Messages
{

public void doAction(Communicator connection,int maxRetries) throws Exception
{

   String reply= sendMessage(connection,TelloCommands.CommandsMap.get("COMMAND_MODE"),maxRetries);
    if(reply.equals("ok"))
    {
        FlierStatusUpdate.droneState.setInCommandMode(true);
    }
}

}