package messages;
import common.*;
import flier.FlierStatusUpdate;

import java.util.Scanner;

public class Right extends Messages
{

    public void doAction(Communicator connection,int maxRetries) throws Exception {
        Scanner in = new Scanner(System.in);
        String rightValue;
        System.out.println("enter right value:");
        rightValue=in.nextLine();

        String reply=sendMessage(connection, (TelloCommands.CommandsMap.get("RIGHT")+" "+rightValue),maxRetries);
        int right=Integer.parseInt(rightValue);
        if(reply.equals("ok"))
        {
            FlierStatusUpdate.droneState.move(0,right,0);
        }
    }
}