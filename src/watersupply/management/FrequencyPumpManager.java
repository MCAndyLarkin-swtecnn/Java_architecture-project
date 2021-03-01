package watersupply.management;

import com.google.gson.Gson;
import watersupply.PairOf;
import watersupply.consumers.WaterUser;
import watersupply.odserver.Observer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import static watersupply.ExampleStorage.*;

public class FrequencyPumpManager implements WaterSupplyManager, Observer {//Main management interface
    private FrequencyPump pump;
    ArrayList<WaterUser> consumers = null;
    private final HashMap<PowerGrades, PairOf<Double, Integer>> pumpPowerTable;

    private final int maximalPressure;//Pmax, bar
    //Maximal Pressure allowed for the water supply ways

    private int maximalPumpPowerfull;// Amax, m3/sec

    private int necessaryPressure;//P,bar
    private int currentPowerful;//liters/sec

    private boolean activated = false;

    @Override
    public void setNecessaryPressure(int necessaryPressure){
        if(!pump.waterExist()){
            currentPowerful = 0;
            return;
        }
        if (necessaryPressure > maximalPressure) return;
        this.necessaryPressure = necessaryPressure;

//        Calculate new powerful (in liters/sec) for new pressure:
        int newPowerful;
        writeDebug("Manager", "Calculate new powerful");

        //fing better value of powerfull in PowerGrades

        //Lets better value is:
        currentPowerful = PowerGrades.Minimal.powerful();
        //So

        //Send new voltage to pump
        pump.correctPressure(pumpPowerTable.get(PowerGrades.Minimal));

        activated = true;
    }
    FrequencyPumpManager(FrequencyPump pump, File pumpPassport_file, int maximalPressure) throws IOException {
        this.pump = pump;
        this.maximalPressure = maximalPressure;
        Gson gson = new Gson();                             ///External!!
        Reader jsonReader = new BufferedReader(new FileReader(pumpPassport_file));
        HashMap<String, com.google.gson.internal.LinkedTreeMap<String, Double>> fileRepresent = gson.fromJson(jsonReader, HashMap.class);
        jsonReader.close();
        pumpPowerTable = new HashMap<>();
        for (PowerGrades item : PowerGrades.values()) {
            pumpPowerTable.put(item,
                    new PairOf<>(fileRepresent.get(item.grade()).get("voltage"),
                            fileRepresent.get(item.grade()).get("frequency").intValue()));
        }
    }


    @Override
    public int getPressure() {
        return pump.getPressure();
    }

    @Override
    public boolean streamIsWorking() {
        return currentPowerful == 0;
    }


    @Override
    public void addConsumer(WaterUser... newCunsumers) {

        if (this.consumers == null)
            this.consumers = new ArrayList<>();
        for (WaterUser consumer : newCunsumers) {
            consumer.subscribe(this);
            if (!this.consumers.contains(consumer)) this.consumers.add(consumer);
        }
    }

    @Override
    public ArrayList<WaterUser> getConsumer() {
        return consumers;
    }

    @Override
    public void setPump(Pump pump) {
        if(pump.getClass() == FrequencyPump.class) this.pump = (FrequencyPump) pump;
    }

    @Override
    public FrequencyPump getPump(){
        return pump;
    }

    @Override
    public void applyChanges() {//Ethernet/Radio connection
        writeDebug("Manager", "Update summary expense");
        if(!pump.waterExist()){
            currentPowerful = 0;
            return;
        }

        //get Current Expense of all consumers
        getExpense();
        //fing better value of powerfull in PowerGrades

        //Lets better value is:
        currentPowerful = PowerGrades.Average.powerful();
        //So

        //Send new voltage to pump
        pump.correctPressure(pumpPowerTable.get(PowerGrades.Average));
    }

    private int getExpense() {
        int expense = 0;
        if (this.consumers != null)
            for (WaterUser consumer : consumers) {
                expense += consumer.getExpense();
            }
        return expense;
    }

}
