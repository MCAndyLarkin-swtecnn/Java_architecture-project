package watersupply.consumers;

import java.util.ArrayList;
import java.util.List;

public class ComplexConsumer implements WaterUser {
    private final ArrayList<WaterUser> subConsumers;                                                                               //Why List?
    private int summaryExpense = 0;
    private final String name;

    public ComplexConsumer(List<WaterUser> consumers){
        name = String.valueOf(hashCode());
        subConsumers = new ArrayList<>(consumers);
    }
    public ComplexConsumer(String name, List<WaterUser> consumers){
        this.name = name;
        subConsumers = new ArrayList<>(consumers);
    }

    @Override
    public int getExpense() {
        updateExpense();
        return summaryExpense;
    }

    @Override
    public void updateExpense() {
        summaryExpense = 0;
        for (WaterUser consumer : subConsumers){
            summaryExpense +=consumer.getExpense();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public void addConsumer(WaterUser consumer){
        subConsumers.add(consumer);
    }

}
