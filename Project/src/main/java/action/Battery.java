package action;
import common.*;
import messages.TelloCommands;
import messages.Messages;
public class Battery extends Messages
{

    public void doAction(Communicator connection,int maxRetries) throws Exception {

        String reply = null;
        while (maxRetries > 0) {
            connection.send(TelloCommands.CommandsMap.get("BATTERY"));
            reply = connection.receive();
            if (reply.equals("ok")) {
                break;
            }
            System.out.println("Remaining retries: " + maxRetries);
            maxRetries--;
        }
        if (reply == null || !reply.equals("ok"))
            return;

         }
}