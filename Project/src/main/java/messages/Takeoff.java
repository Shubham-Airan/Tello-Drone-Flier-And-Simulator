package messages;
import common.*;
import flier.FlierStatusUpdate;

public class Takeoff extends Messages
{

    public void doAction(Communicator connection,int maxRetries) throws Exception {

        FlierStatusUpdate.droneState.resetState();
        String reply=sendMessage(connection,(TelloCommands.CommandsMap.get("TAKE_OFF")),maxRetries);
        if(reply.equals("ok"))
        {
            FlierStatusUpdate.droneState.setHasTakenOff(true);
            FlierStatusUpdate.droneState.move(0,0,100);

        }



    }
}