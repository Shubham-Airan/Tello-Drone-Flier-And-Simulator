package messages;

import java.util.HashMap;

public class TelloCommands {

  public static HashMap<String,String> CommandsMap = new HashMap<String,String>();
        public TelloCommands()
      {
        CommandsMap.put("COMMAND_MODE","command");
        CommandsMap.put("TAKE_OFF","takeoff");
        CommandsMap.put("Land","land");

        CommandsMap.put("UP","up");
        CommandsMap.put("Down","down");
        CommandsMap.put("LEFT","left");
        CommandsMap.put("RIGHT","right");
        CommandsMap.put("FORWARD","forward");
        CommandsMap.put("BACK","back");

        CommandsMap.put("CW","cw");
        CommandsMap.put("CCW","ccw");

        CommandsMap.put("Flip","flip");

        CommandsMap.put("STOP","stop");
        CommandsMap.put("BATTERY","battery?");
      }
}
