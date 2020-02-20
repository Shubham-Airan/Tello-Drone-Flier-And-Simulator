package messages;
import common.*;
import flier.FlierStatusUpdate;

import java.util.Scanner;

public class Cww extends Messages
{

    public void doAction(Communicator connection,int maxRetries) throws Exception {
        Scanner in = new Scanner(System.in);
        String cwwValue;
        System.out.println("enter cww value:");
        cwwValue=in.nextLine();

        String reply=sendMessage(connection,(TelloCommands.CommandsMap.get("CWW")+" "+cwwValue),maxRetries );
        int cww=Integer.parseInt(cwwValue);
        if(reply.equals("ok"))
        {
            FlierStatusUpdate.droneState.rotate(cww);
        }
        }
}