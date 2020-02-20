package messages;
import common.*;
import flier.FlierStatusUpdate;

import java.util.Scanner;

public class Cw extends Messages
{

    public void doAction(Communicator connection,int maxRetries) throws Exception {
        Scanner in = new Scanner(System.in);
        String cwValue;
        System.out.println("enter cw value:");
        cwValue=in.nextLine();

        String reply=sendMessage(connection,(TelloCommands.CommandsMap.get("CW")+" "+cwValue), maxRetries);
        int cw=Integer.parseInt(cwValue);
        if(reply.equals("ok"))
        {
            FlierStatusUpdate.droneState.rotate(-cw);
        }

    }
}