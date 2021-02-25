package watersupply.management;

import watersupply.consumers.WaterUser;

public class PumpManager implements  waterSupplyManager{
    private Pump pump;
    public PumpManager(Pump pump){
        this.pump = pump;
    }
    public void replacePump(Pump pump){
        this.pump = pump;
    }

    @Override
    public int getPressure() {
        return 0;
    }

    @Override
    public boolean streamIsWorking() {
        return false;
    }

    @Override
    public void addConsumer(WaterUser... cunsumers) {

    }
}
