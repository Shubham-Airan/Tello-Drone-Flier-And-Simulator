package simulator;
import common.*;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SimulatorStatusUpdate extends Thread
{
    Communicator simulatorStatusCommunicator;
    public static DroneState droneState=new DroneState();

    public SimulatorStatusUpdate() throws Exception
    {
        DatagramSocket simulatorStatusSocket = new DatagramSocket();
        simulatorStatusCommunicator = new Communicator(8890, InetAddress.getByName("127.0.0.1"),simulatorStatusSocket);
    }

    public void run () {
        while (true)
        {
            try {
                Status s=new Status(droneState.getPitch(), droneState.getRoll(), droneState.getYaw(),droneState.getSpeedX(), droneState.getSpeedY(), droneState.getSpeedZ(),
                        droneState.getLowTemperature(),droneState.getHighTemperature(), droneState.getFlightDistance(), droneState.getHeight(),
                        droneState.getBatteryPercentage(), droneState.getBarometerMeasurement(), droneState.getMotorTime(),
                        droneState.getAccelerationX(), droneState.getAccelerationY(), droneState.getAccelerationZ());
                String replyStatus = s.getMessageText();
                simulatorStatusCommunicator.send(replyStatus);
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }}


}