package watersupply.management;

import watersupply.consumers.WaterUser;
import watersupply.odserver.Observer;

import static watersupply.ExampleStorage.writeDebug;

public interface Pump {
    void turnOn();
    void turnOff();
}
