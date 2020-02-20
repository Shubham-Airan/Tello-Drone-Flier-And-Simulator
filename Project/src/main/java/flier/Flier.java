package flier;

import common.Communicator;
import missions.*;

import java.lang.*;
import java.net.DatagramSocket;
import java.util.HashMap;

public class Flier extends Thread{
        public int choice=1;

        Communicator communicatorStatus;
        public static HashMap<Integer, Mission> MissionCollection = new HashMap<Integer, Mission>();
        DatagramSocket flierSocket;

          public Flier() throws Exception{

            Mission1 m1 = new Mission1();
            Mission2 m2 = new Mission2();
            Mission3 m3 = new Mission3();
            MissionCollection.put(1,m1);
            MissionCollection.put(2,m2);
            MissionCollection.put(3,m3);
              Mission4 m4 = new Mission4();
              MissionCollection.put(4,m4);
        }

        public void flying(int missionOption, Communicator connection, int maxRetries) throws Exception {
                Mission m;
                m= MissionCollection.get(missionOption);
                m.execute(connection, maxRetries);
                }
			}