package common;

import org.junit.Test;

import static org.junit.Assert.*;

public class StatusTest {

    @Test
    public void constructorTest(){
        DroneState droneState= new DroneState();
        Status status=new Status(droneState.getPitch(), droneState.getRoll(),droneState.getYaw(), droneState.getSpeedX(), droneState.getSpeedY(), droneState.getSpeedZ(),
                droneState.getLowTemperature(), droneState.getHighTemperature(), droneState.getFlightDistance(),droneState.getHeight(),
                droneState.getBatteryPercentage(),droneState.getBarometerMeasurement(),droneState.getMotorTime(),
                droneState.getAccelerationX(), droneState.getAccelerationY(), droneState.getAccelerationZ());
        Double value=0.0;
        Integer value1=0;
        Integer battery=100;
        assertEquals(value1,status.getPitch());
        assertEquals(value1,status.getRoll());
        assertEquals(value1,status.getYaw());
        assertEquals(value1,status.getSpeedX());
        assertEquals(value1,status.getSpeedY());
        assertEquals(value1,status.getSpeedZ());
        assertEquals(value1,status.getLowTemperature());
        assertEquals(value1,status.getHighTemperature());
        assertEquals(value1,status.getFlightDistance());
        assertEquals(value1,status.getHeight());

        assertEquals(battery,status.getBatteryPercentage());
        assertEquals(value,status.getBarometerMeasurement());
        assertEquals(value1,status.getMotorTime());

        assertEquals(value,status.getAccelerationX());
        assertEquals(value,status.getAccelerationY());
        assertEquals(value,status.getAccelerationZ());
    }


    @Test
    public void getKeyWord() {
        String value= Status.getKeyWord();
        assertEquals("mid",value);
    }

    @Test
    public void getMessageText() {
        DroneState droneState= new DroneState();
        Status status= new Status(droneState.getPitch(), droneState.getRoll(),droneState.getYaw(), droneState.getSpeedX(), droneState.getSpeedY(), droneState.getSpeedZ(),
                droneState.getLowTemperature(), droneState.getHighTemperature(), droneState.getFlightDistance(),droneState.getHeight(),
                droneState.getBatteryPercentage(),droneState.getBarometerMeasurement(),droneState.getMotorTime(),
                droneState.getAccelerationX(), droneState.getAccelerationY(), droneState.getAccelerationZ());
        String value= "mid:-1;x:0;y:0;z:0;mpry:0,0,0;pitch:0;roll:0;yaw:0;vgx:0;vgy:0;vgz:0;templ:0;temph:0;tof:0;h:0;bat:100;baro:0.00;time:0;agx:0.00;agy:0.00;agz:0.00";
        assertEquals(value,status.getMessageText());
    }

    @Test
    public void getMessageType() {
        DroneState droneState= new DroneState();
        Message message =new Status(droneState.getPitch(), droneState.getRoll(),droneState.getYaw(), droneState.getSpeedX(), droneState.getSpeedY(), droneState.getSpeedZ(),
                droneState.getLowTemperature(), droneState.getHighTemperature(), droneState.getFlightDistance(),droneState.getHeight(),
                droneState.getBatteryPercentage(),droneState.getBarometerMeasurement(),droneState.getMotorTime(),
                droneState.getAccelerationX(), droneState.getAccelerationY(), droneState.getAccelerationZ());
        String value= message.getMessageType();
        assertEquals("status",value);
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
}