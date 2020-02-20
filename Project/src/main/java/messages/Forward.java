package messages;
import common.*;
import flier.FlierStatusUpdate;

import java.util.Scanner;

public class Forward extends Messages
{

    public void doAction(Communicator connection,int maxRetries) throws Exception {
        Scanner in = new Scanner(System.in);
        String forwardValue;
        System.out.println("enter forward value:");
        forwardValue=in.nextLine();

        String reply=sendMessage(connection, (TelloCommands.CommandsMap.get("FORWARD")+" "+forwardValue),maxRetries);

        int forward=Integer.parseInt(forwardValue);
        if(reply.equals("ok"))
        {
            FlierStatusUpdate.droneState.move(forward,0,0);
        }


    }
}