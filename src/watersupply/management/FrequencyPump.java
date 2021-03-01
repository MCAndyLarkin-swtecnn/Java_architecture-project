package watersupply.management;

import watersupply.Hardware_realization;
import watersupply.PairOf;
import static watersupply.ExampleStorage.*;

public class FrequencyPump implements Pump {//Automatic
    //Pump Passport
    private Barometer barometer;
    //Next may be declared other passport data.
    //...

    public void setBarometer(Barometer barometer) {
        this.barometer = barometer;
    }

    public boolean waterExist(){
        return true;
    }

    public int getPressure() {
        return barometer.getPressure();
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }
    @Hardware_realization
    public void correctPressure(PairOf<Double, Integer> newVoltage){
        writeDebug("Pump", "Applying new voltage");

        //Apply new voltage
    }
}
