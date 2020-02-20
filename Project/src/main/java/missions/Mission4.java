package missions;
import messages.*;
import common.*;
import flier.FlierStatusUpdate;
import java.util.ArrayList;

public class Mission4 implements Mission
{
public void execute(Communicator communicator, int maxRetries) throws Exception
{
     ArrayList<Messages> actions = new ArrayList<>();

     actions.add(new Command());
     actions.add(new Takeoff());
     actions.add(new Cw());
     actions.add(new Land());


     for (Messages action : actions)
     {
          if((FlierStatusUpdate.droneState.getBatteryPercentage()<30)|| (FlierStatusUpdate.droneState.getHighTemperature()>40))
          {
               actions.get(actions.size()-1).doAction(communicator,maxRetries);
               break;
          }
         action.doAction(communicator,maxRetries);
          String rp=FlierStatusUpdate.droneState.getPosition();
          System.out.println(rp);
     }
}
}