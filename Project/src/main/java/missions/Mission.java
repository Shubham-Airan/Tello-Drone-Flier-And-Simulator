package missions;

import common.Communicator;

public interface Mission
{

public void execute(Communicator communicatorMission,int maxRetries)  throws Exception;

}