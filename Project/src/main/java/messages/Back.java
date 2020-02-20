package messages;
import common.*;
import flier.FlierStatusUpdate;

import java.util.Scanner;

public class Back extends Messages
{

    public void doAction(Communicator connection,int maxRetries) throws Exception {
        Scanner in = new Scanner(System.in);
        String backValue,reply;
        System.out.println("enter back value:");
        backValue=in.nextLine();

        reply=sendMessage(connection,(TelloCommands.CommandsMap.get("BACK")+" "+backValue),maxRetries );
        int back=Integer.parseInt(backValue);
        if(reply.equals("ok"))
        {
            FlierStatusUpdate.droneState.move(-back,0,0);
        }

    }
}