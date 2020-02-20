package flier;
import common.*;
import java.net.DatagramSocket;
import java.util.logging.*;
public class FlierStatusUpdate extends Thread
{
    public static DroneState droneState = new DroneState();
    private DatagramSocket flierStatusSocket= new DatagramSocket(8890);
    private Communicator communicatorFlierStatus =new Communicator(flierStatusSocket);;
    private Logger logger;

    public FlierStatusUpdate(String logFile) throws Exception
{
    logger = Logger.getLogger(FlierStatusUpdate.class.getName());
    FileHandler flierStatus = new FileHandler(logFile);
    SimpleFormatter formatter = new SimpleFormatter();
    flierStatus.setFormatter(formatter);
    logger.setUseParentHandlers(false);
    logger.addHandler(flierStatus);


}

    public void run () {
        while(true) {

            String reply1 = null;
            byte[] bytesReceivedStatus = null;

            try {
                reply1 = communicatorFlierStatus.receive();
                Status status = new Status(reply1);
//                bytesReceivedStatus = reply1.getBytes(StandardCharsets.UTF_8);
//                Message.decode(bytesReceivedStatus,0,bytesReceivedStatus.length);
                droneState.updateFlyingInfo(status);
                Thread.sleep(100);
                logger.info(reply1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}