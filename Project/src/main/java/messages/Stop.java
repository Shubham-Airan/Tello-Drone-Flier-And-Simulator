package messages;
import common.*;
public class Stop extends Messages
{

    public void doAction(Communicator connection,int maxRetries) throws Exception {

       String reply= sendMessage(connection,(TelloCommands.CommandsMap.get("STOP")),maxRetries);

    }
}