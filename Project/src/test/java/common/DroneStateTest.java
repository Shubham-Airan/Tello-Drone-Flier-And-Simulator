package common;
import org.junit.Test;

import static org.junit.Assert.*;

public class DroneStateTest {

    @Test
    public void isInCommandMode() {
    }

    @Test
    public void setInCommandMode() {
        DroneState droneState= new DroneState();
        assertEquals(false, droneState.isInCommandMode());
        droneState.setInCommandMode(true);
        droneState.resetState();
    }

    @Test
    public void hasTakenOff() {

    }

    @Test
    public void setHasTakenOff() {
        DroneState droneState= new DroneState();
        assertEquals(false,droneState.hasTakenOff());
        droneState.setHasTakenOff(true);
        droneState.resetState();
    }

    @Test
    public void isVideoStreamOn() {
    }

    @Test
    public void setVideoStreamOn() {
        DroneState droneState= new DroneState();
        assertEquals(false,droneState.isVideoStreamOn());
        droneState.setVideoStreamOn(true);
    }

    @Test
    public void getCurrentFlightTime() {
    }

    @Test
    public void setCurrentFlightTime() {
        DroneState droneState= new DroneState();
        Double time=0.0;
        assertEquals(time,droneState.getCurrentFlightTime());

        droneState.setCurrentFlightTime(11.5);
    }

    @Test
    public void updateFlyingInfo() {
        DroneState droneState= new DroneState();
        String statusReceived= "mid:-1;x:0;y:0;z:0;mpry:0,0,0;pitch:0;roll:0;yaw:0;vgx:0;vgy:0;vgz:0;templ:0;temph:0;tof:0;h:0;bat:100;baro:0.00;time:0;agx:0.00;agy:0.00;agz:0.00";
        Status status= new Status(statusReceived);
        droneState.updateFlyingInfo(status);
        assertEquals(droneState.getPitch(),status.getPitch());
        assertEquals(droneState.getRoll(),status.getRoll());
        assertEquals(droneState.getYaw(),status.getYaw());
        assertEquals(droneState.getSpeedX(),status.getSpeedX());
        assertEquals(droneState.getSpeedY(),status.getSpeedY());
        assertEquals(droneState.getSpeedZ(),status.getSpeedZ());
        assertEquals(droneState.getLowTemperature(),status.getLowTemperature());
        assertEquals(droneState.getHighTemperature(),status.getHighTemperature());
        assertEquals(droneState.getFlightDistance(),status.getFlightDistance());
        assertEquals(droneState.getHeight(),status.getHeight());

        assertEquals(droneState.getBatteryPercentage(),status.getBatteryPercentage());
        assertEquals(droneState.getBarometerMeasurement(),status.getBarometerMeasurement());
        assertEquals(droneState.getMotorTime(),status.getMotorTime());

        assertEquals(droneState.getAccelerationX(),status.getAccelerationX());
        assertEquals(droneState.getAccelerationY(),status.getAccelerationY());
        assertEquals(droneState.getAccelerationZ(),status.getAccelerationZ());
    }

    @Test
    public void getStateTimestamp() {
    }

    @Test
    public void move() {
        DroneState droneState=new DroneState();
        droneState.move(0.0,0.0,0.0);
        Double value=0.0;
        assertEquals(value,droneState.getPositionX());
        assertEquals(value,droneState.getPositionY());
        assertEquals(value,droneState.getPositionZ());
    }

    @Test
    public void rotate() {
        DroneState droneState= new DroneState();
        droneState.rotate(0);
        assertEquals(0,droneState.getOrientation());
    }

    @Test
    public void getPositionX() {
    }

    @Test
    public void getPositionY() {
    }

    @Test
    public void getPositionZ() {
    }

    @Test
    public void getPitch() {
    }

    @Test
    public void getRoll() {
    }

    @Test
    public void getYaw() {
    }

    @Test
    public void getSpeedX() {
    }

    @Test
    public void getSpeedY() {
    }

    @Test
    public void getSpeedZ() {
    }

    @Test
    public void getAccelerationX() {
    }

    @Test
    public void getAccelerationY() {
    }

    @Test
    public void getAccelerationZ() {
    }

    @Test
    public void getLowTemperature() {
    }

    @Test
    public void getHighTemperature() {
    }

    @Test
    public void getFlightDistance() {
    }

    @Test
    public void getHeight() {
    }

    @Test
    public void getBatteryPercentage() {
    }

    @Test
    public void getBarometerMeasurement() {
    }

    @Test
    public void getMotorTime() {
    }

    @Test
    public void getOrientation() {
        DroneState droneState= new DroneState();
        int value=0;
        assertEquals(value,droneState.getOrientation());
    }

    @Test
    public void resetState() {
    }

    @Test
    public void resetFlyingInfo() {
    }

    @Test
    public void getPosition() {
    }
}