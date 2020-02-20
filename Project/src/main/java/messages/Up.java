package messages;
import common.*;
import flier.FlierStatusUpdate;

import java.util.Scanner;

public class Up extends Messages
{

public void doAction(Communicator connection,int maxRetries) throws Exception {
    Scanner in = new Scanner(System.in);
    String upValue;
    System.out.println("enter up value:");
    upValue=in.nextLine();

    String reply=sendMessage(connection,(TelloCommands.CommandsMap.get("UP")+" "+upValue),maxRetries);

    int up=Integer.parseInt(upValue);
    if(reply.equals("ok"))
    {
        FlierStatusUpdate.droneState.move(0,0,up);
    }
}
}