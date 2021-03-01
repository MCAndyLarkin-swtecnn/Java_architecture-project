package watersupply.management;

import watersupply.consumers.WaterUser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static watersupply.ExampleStorage.MAXIMAL_PRESSURE;

public interface WaterSupplyManager {
    int getPressure();
    boolean streamIsWorking();
    void setNecessaryPressure(int necessaryPressure);
    void addConsumer(WaterUser... cunsumers);
    ArrayList<WaterUser> getConsumer();

    void setPump(Pump pump);
    Pump getPump();

    static FrequencyPumpManager FrequencyPumpManagerFactory(File pumpPassport, int maximalPressure, int currentPressure) {
        FrequencyPumpManager manager;
        try{
            manager = new FrequencyPumpManager(new FrequencyPump(),pumpPassport, maximalPressure);
            manager.getPump().setBarometer(new Barometer());
            manager.setNecessaryPressure(currentPressure);
        }catch (IOException ex){
            manager = null;
        }
        return manager;
    }
}
