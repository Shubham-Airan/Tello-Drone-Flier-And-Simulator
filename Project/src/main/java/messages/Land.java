package messages;
import common.*;
import flier.FlierStatusUpdate;

public class Land extends Messages
{

    public void doAction(Communicator connection,int maxRetries) throws Exception {

       String reply= sendMessage(connection,(TelloCommands.CommandsMap.get("Land")),maxRetries);
        if(reply.equals("ok"))
        {
            FlierStatusUpdate.droneState.move(0.0,0.0,-100.0);
            FlierStatusUpdate.droneState.resetState();
        }
    }
}