package messages;
import common.*;
import flier.FlierStatusUpdate;

import java.util.Scanner;

public class Down extends Messages
{

public void doAction(Communicator connection,int maxRetries) throws Exception {
    Scanner in = new Scanner(System.in);
    String downValue;
    System.out.println("enter down value:");
    downValue=in.nextLine();

    String reply=sendMessage(connection,(TelloCommands.CommandsMap.get("Down")+" "+downValue),maxRetries );
    int down=Integer.parseInt(downValue);
    if(reply.equals("ok"))
    {
        FlierStatusUpdate.droneState.move(0,0,-down);
    }
    }
}