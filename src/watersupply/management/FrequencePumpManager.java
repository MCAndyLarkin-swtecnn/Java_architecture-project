package watersupply.management;

import watersupply.consumers.WaterUser;

import java.util.ArrayList;

public class FrequencePumpManager implements WaterSupplyManager {//Main management interface
    private Pump pump;
    ArrayList<WaterUser> consumers;


    @Override
    public int getPressure() {
        return 0;
    }

    @Override
    public boolean streamIsWorking() {
        return false;
    }

    @Override
    public int getDepressure() {
        return 0;
    }

    @Override
    public void addConsumer(WaterUser... cunsumers) {

    }

    @Override
    public String[] getUnreadLogs() {
        return new String[0];
    }

    @Override
    public String[] getAllLogs() {
        return new String[0];
    }

    public FrequencePumpManager(Pump pump){
        this.pump = pump;
    }
    public void replacePump(Pump pump){
        this.pump = pump;
    }
}
