package simulator;
import common.*;
import messages.*;

import java.util.*;

class ValidateParameter
{
    private String Data;
    private String [] splitedReply;

    private ArrayList<String> listNeedtakeoff = new ArrayList<String>();
    private ArrayList<String> simpleMoveCommands = new ArrayList<String>();
    private ArrayList<String> simpleFlipCommands = new ArrayList<String>();
    private ArrayList<String> simpleRotateCommands = new ArrayList<String>();
    ValidateParameter(String data) {
        this.Data = data;
        this.splitedReply = data.split(" ");

        listNeedtakeoff.add(TelloCommands.CommandsMap.get("Down"));
        listNeedtakeoff.add(TelloCommands.CommandsMap.get("Land"));
        listNeedtakeoff.add(TelloCommands.CommandsMap.get("LEFT"));
        listNeedtakeoff.add(TelloCommands.CommandsMap.get("UP"));
        listNeedtakeoff.add(TelloCommands.CommandsMap.get("RIGHT"));
        listNeedtakeoff.add(TelloCommands.CommandsMap.get("FORWARD"));
        listNeedtakeoff.add(TelloCommands.CommandsMap.get("BACK"));
        listNeedtakeoff.add(TelloCommands.CommandsMap.get("CW"));
        listNeedtakeoff.add(TelloCommands.CommandsMap.get("CCW"));
        listNeedtakeoff.add(TelloCommands.CommandsMap.get("Flip"));

        simpleMoveCommands.add(TelloCommands.CommandsMap.get("UP"));
        simpleMoveCommands.add(TelloCommands.CommandsMap.get("Down"));
        simpleMoveCommands.add(TelloCommands.CommandsMap.get("Land"));
        simpleMoveCommands.add(TelloCommands.CommandsMap.get("LEFT"));
        simpleMoveCommands.add(TelloCommands.CommandsMap.get("RIGHT"));
        simpleMoveCommands.add(TelloCommands.CommandsMap.get("FORWARD"));

        simpleFlipCommands.add("r");
        simpleFlipCommands.add("l");
        simpleFlipCommands.add("f");
        simpleFlipCommands.add("b");

        simpleRotateCommands.add(TelloCommands.CommandsMap.get("CW"));
        simpleRotateCommands.add(TelloCommands.CommandsMap.get("CCW"));

    }

    boolean validateCommand(){

        if(TelloCommands.CommandsMap.containsValue(splitedReply[0]))
        {
            return true;
        }
        else
            return false;
    }

    void validParameter(Communicator communicateServer,DroneState droneState ) throws Exception
    {
        if(listNeedtakeoff.contains(splitedReply[0]) && (!droneState.hasTakenOff()))
        {
            communicateServer.send("can not proceed "+Data +"drone has not taken off");
            return;
        }
        else if(listNeedtakeoff.contains(splitedReply[0]) && (droneState.hasTakenOff()))
        {
            if(simpleMoveCommands.contains(splitedReply[0]))
                {
                    int moveParameter=Integer.parseInt(splitedReply[1]);
                    if(moveParameter>20 && moveParameter <500)
                    {
                        communicateServer.send("ok");
                        return;
                    }
                    else
                    {
                        communicateServer.send("error");
                        System.out.println("not a valid parameter for "+ splitedReply[0]);
                        return;
                        }
                }

                else if(splitedReply[0].equals(TelloCommands.CommandsMap.get("Flip")))
                {
                    if(simpleFlipCommands.contains(splitedReply[1]))
                    {
                        communicateServer.send("ok");

                    }
                    else{
                        communicateServer.send("error");
                        System.out.println("not a valid parameter for "+ splitedReply[0]);
                    }
                }

                else if(simpleRotateCommands.contains(splitedReply[0]))
            {
                int rotateParameter=Integer.parseInt(splitedReply[1]);
                if(rotateParameter>0 && rotateParameter <=360)
                {
                    communicateServer.send("ok");
                    return;
                }
                else
                {
                    communicateServer.send("error");
                    System.out.println("not a valid parameter for "+ splitedReply[0]);
                    return;
                }
            }
        }

        else{
            if(splitedReply[0].equals(TelloCommands.CommandsMap.get("STOP")))
            {
                if(droneState.hasTakenOff())
                {
                communicateServer.send("ok");
                System.out.println("hovering in there");}

                else{
                    communicateServer.send("error");
                    System.out.println("can not hover, has not taken off");
                }

            }

           else if(splitedReply[0].equals(TelloCommands.CommandsMap.get("BATTERY")))
            {
                communicateServer.send("battery is 30%");
                System.out.println("battery is 30%");

            }
        }
    }


    }