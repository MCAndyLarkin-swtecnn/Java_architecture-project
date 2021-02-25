import watersupply.ExampleStorage;
import watersupply.consumers.ComplexConsumer;
import watersupply.consumers.RandomExpensioner;
import watersupply.consumers.SingleCunsumer;
import watersupply.consumers.WaterUser;

import java.util.List;



public class Main {
    public static void main(String[] args){
        RandomExpensioner randomExpensioner = new RandomExpensioner();

        SingleCunsumer myHome = new SingleCunsumer("My home", randomExpensioner);
        SingleCunsumer myUniversity = new SingleCunsumer("My University", randomExpensioner);
        ComplexConsumer blueQuartal = new ComplexConsumer(List.of(myHome, myUniversity));

        SingleCunsumer myFriendsHome = new SingleCunsumer("My friends home", randomExpensioner);
        ComplexConsumer greenStreet = new ComplexConsumer(List.of(blueQuartal,myFriendsHome));

        SingleCunsumer myParentsHome = new SingleCunsumer("My parents home", randomExpensioner);
        ComplexConsumer redDistrict = new ComplexConsumer("Red District", List.of(greenStreet, myParentsHome));

        SingleCunsumer myGarage = new SingleCunsumer("My garage", randomExpensioner);
        redDistrict.addConsumer(myGarage);

        ExampleStorage.writeDebug("Summary expense/"+redDistrict.getName(), String.valueOf(redDistrict.getExpense()));

    }
}
