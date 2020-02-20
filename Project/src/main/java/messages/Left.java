package messages;
import common.*;
import flier.FlierStatusUpdate;

import java.util.Scanner;

public class Left extends Messages
{

public void doAction(Communicator connection,int maxRetries) throws Exception {
    Scanner in = new Scanner(System.in);
    String leftValue;
    System.out.println("enter left value:");
    leftValue=in.nextLine();

   String reply= sendMessage(connection,(TelloCommands.CommandsMap.get("LEFT")+" "+leftValue),maxRetries);
    int left=Integer.parseInt(leftValue);
    if(reply.equals("ok"))
    {
        FlierStatusUpdate.droneState.move(0,-left,0);
    }
}
}