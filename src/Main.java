
import static watersupply.ExampleStorage.*;
import watersupply.consumers.*;

import java.io.File;
import java.util.List;



public class Main {
    public static void main(String[] args){

        Source fileSource = new FileSource(new File("ExpenseData.json"));
        Source randomExpensioner = new RandomExpensioner();

        SingleCunsumer myHome = new SingleCunsumer("My home", randomExpensioner,1);
        SingleCunsumer myUniversity = new SingleCunsumer("My University", randomExpensioner,2);
        ComplexConsumer blueQuartal = new ComplexConsumer(List.of(myHome, myUniversity));

        SingleCunsumer myFriendsHome = new SingleCunsumer("My friends home", randomExpensioner,3);
        ComplexConsumer greenStreet = new ComplexConsumer(List.of(blueQuartal,myFriendsHome));

        SingleCunsumer myParentsHome = new SingleCunsumer("My parents home", randomExpensioner,4);
        ComplexConsumer redDistrict = new ComplexConsumer("Red District", List.of(greenStreet, myParentsHome));

        SingleCunsumer myGarage = new SingleCunsumer("My garage", randomExpensioner,5);
        redDistrict.addConsumer(myGarage);
        redDistrict.replaceSource(fileSource);

        writeDebug("Summary expense/"+redDistrict.getName(), String.valueOf(redDistrict.getExpense()));

    }
}
