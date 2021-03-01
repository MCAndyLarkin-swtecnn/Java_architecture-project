
import static watersupply.ExampleStorage.*;

import watersupply.consumers.*;
import watersupply.management.WaterSupplyManager;

import java.io.File;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        //New manager creating
        WaterSupplyManager waterManager = WaterSupplyManager.FrequencyPumpManagerFactory(
                new File("PumpPasport.json"),
                MAXIMAL_PRESSURE,
                8);


        //New system of consumers creating

        Source randomExpensioner = new RandomExpensioner();

        SingleCunsumer myHome = new SingleCunsumer("My home", randomExpensioner, 1);
        SingleCunsumer myUniversity = new SingleCunsumer("My University", randomExpensioner, 2);
        ComplexConsumer blueQuartal = new ComplexConsumer("Blue quartal", List.of(myHome, myUniversity), 3);

        SingleCunsumer myFriendsHome = new SingleCunsumer("My friends home", randomExpensioner, 4);
        ComplexConsumer greenStreet = new ComplexConsumer("Green street", List.of(blueQuartal, myFriendsHome), 5);

        SingleCunsumer myParentsHome = new SingleCunsumer("My parents home", randomExpensioner, 6);
        ComplexConsumer redDistrict = new ComplexConsumer("Red District", List.of(greenStreet, myParentsHome), 7);

        SingleCunsumer myGarage = new SingleCunsumer("My garage", randomExpensioner, 8);
        redDistrict.addConsumer(myGarage);

        Source fileSource = Source.fileSourceBuilder(new File("ExpenseData.json"));

        assert fileSource != null;                                                                                      //File must exist
                                                                                                                        // and have allowed
                                                                                                                        // format
        redDistrict.replaceSource(fileSource);

        TestSource myHomeSource = new TestSource(1000, myHome);
        myHome.replaceSource(myHomeSource);

        writeDebug("Summary expense/" + redDistrict.getName(), String.valueOf(redDistrict.getExpense()));
        endLine();

        //Include consumers in manager rights
        assert waterManager != null;
        waterManager.addConsumer(redDistrict);

        //Change Source expense values
        myHomeSource.setCurrentExpense(2000);//expense change imitation
                                                // (For example: anybody in me home opened or closed valve)
        endLine();

        //Change necessary pressure
        waterManager.setNecessaryPressure(12);
    }
}
