package watersupply.management;

import watersupply.consumers.WaterUser;

public interface waterSupplyManager {
    int getPressure();//Manometer
    boolean streamIsWorking();
    void addConsumer(WaterUser... cunsumers);
}
