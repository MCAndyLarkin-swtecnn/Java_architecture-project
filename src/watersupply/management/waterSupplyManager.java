package watersupply.management;

import watersupply.consumers.WaterUser;

public interface waterSupplyManager {
    int getPressure();
    boolean streamIsWorking();
    void addConsumer(WaterUser... cunsumers);
}
