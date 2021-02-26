package watersupply.management;

import com.google.gson.Gson;
import watersupply.myPair;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static watersupply.ExampleStorage.*;

public class FrequencePump implements Pump {
    private final HashMap<PowerGrades, myPair<Double, Integer>> pumpPasport;

//    Entry<Double, Integer> getVoltageAndFrequency();
//    void


    public FrequencePump(File pumpPasport_file) throws IOException {
        Gson gson = new Gson();                             ///External!!
        Reader jsonReader = new BufferedReader(new FileReader(pumpPasport_file));
        HashMap<String, com.google.gson.internal.LinkedTreeMap<String, Double>> fileRepresent = gson.fromJson(jsonReader, HashMap.class);
        jsonReader.close();
        pumpPasport = new HashMap<>();

        for (PowerGrades item : PowerGrades.values()) {

            pumpPasport.put(item,
                    new myPair<>(fileRepresent.get(item.grade()).get("voltage"),
                            fileRepresent.get(item.grade()).get("frequency").intValue()));
        }
    }
}
