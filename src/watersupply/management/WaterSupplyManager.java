package watersupply.management;

import watersupply.consumers.WaterUser;

public interface WaterSupplyManager {
    int getPressure();
    boolean streamIsWorking();
    int getDepressure();
    void addConsumer(WaterUser... cunsumers);
    String[] getUnreadLogs();
    String[] getAllLogs();
}
