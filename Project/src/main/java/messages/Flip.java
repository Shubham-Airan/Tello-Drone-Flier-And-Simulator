package messages;
import common.*;
import flier.FlierStatusUpdate;

import java.util.HashMap;
import java.util.Scanner;

public class Flip extends Messages {

    private HashMap<String,String> Fliptypes = new HashMap<String,String>();

    public Flip(){
        Fliptypes.put("l",TelloCommands.CommandsMap.get("LEFT"));
        Fliptypes.put("r",TelloCommands.CommandsMap.get("RIGHT"));
        Fliptypes.put("f",TelloCommands.CommandsMap.get("FORWARD"));
        Fliptypes.put("b",TelloCommands.CommandsMap.get("BACK"));
    }

    public void doAction(Communicator connection, int maxRetries) throws Exception {
        Scanner in = new Scanner(System.in);
        String flipValue;
        System.out.println("enter flip type:");
        flipValue = in.nextLine();

        if ((FlierStatusUpdate.droneState.getBatteryPercentage() > 60)) {
            String reply=sendMessage(connection, (TelloCommands.CommandsMap.get("Flip") + " " + flipValue), maxRetries);
            if(reply.equals("ok"))
            {
            moveForRespectiveFlip(flipValue); }
        }
        else
        {
            String moveType = Fliptypes.get(flipValue);
            String reply=sendMessage(connection,moveType+" "+"50",maxRetries);
            if(reply.equals("ok"))
            {
                moveForRespectiveFlip(flipValue); }
        }
        }


    private void moveForRespectiveFlip(String flipValue) {
        switch (flipValue)
        {
            case "l":
                FlierStatusUpdate.droneState.move(0,-50,0);
                break;
            case "r":
                FlierStatusUpdate.droneState.move(0,50,0);
                break;
            case "f":
                FlierStatusUpdate.droneState.move(50,0,0);
                break;
            case "b":
                FlierStatusUpdate.droneState.move(-50,0,0);
                break;
        }
    }

}