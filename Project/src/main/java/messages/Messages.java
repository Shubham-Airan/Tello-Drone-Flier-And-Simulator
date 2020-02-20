package messages;
import common.*;

public abstract class Messages

{

//abstract void action();

abstract public void doAction(Communicator communicator,int maxRetries) throws Exception;

    String sendMessage(Communicator connection, String message, int maxRetries) throws Exception {
        String reply = null;
        while (maxRetries > 0) {
            connection.send(message);
            reply = connection.receive();
            if (reply.equals("ok")) {

                   break;
            }
            System.out.println("Remaining retries: " + maxRetries);
            maxRetries--;
        }
        if (reply == null || !reply.equals("ok"))
            return "nothing received";
        else return reply;
    }


}