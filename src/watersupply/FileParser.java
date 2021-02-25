package watersupply;
import com.google.gson.Gson;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import static watersupply.ExampleStorage.*;

public abstract class FileParser {
    static HashMap<String, Double> consumersScore = null;

    public static void parse(File file) {
        String[] splitedName = file.getName().split("\\.");
        switch (splitedName[splitedName.length - 1]) {
            case "json" -> jsonParser(file);
            //For extension
        }

    }
    public static void jsonParser(File file){
        Gson gson = new Gson();
        try {
            Reader jsonReader = new BufferedReader(new FileReader(file));
            consumersScore = gson.fromJson(jsonReader, HashMap.class);
            jsonReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int findScore(int id){
            return  consumersScore.get(String.valueOf(id)).intValue();
    }
}
