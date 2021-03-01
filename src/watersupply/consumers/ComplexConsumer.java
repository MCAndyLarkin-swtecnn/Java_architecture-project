package watersupply.consumers;

import watersupply.odserver.Observer;

import java.util.ArrayList;
import java.util.List;

public class ComplexConsumer extends WaterUser {
    private final ArrayList<WaterUser> subConsumers;

    public ComplexConsumer(List<WaterUser> consumers, int id){
        super("", id);
        name = String.valueOf(hashCode());
        subConsumers = new ArrayList<>(consumers);
    }
    public ComplexConsumer(String name, List<WaterUser> consumers, int id){
        super(name, id);
        this.name = name;
        subConsumers = new ArrayList<>(consumers);
    }
    @Override
    public void subscribe(Observer... subscribers){
        for (WaterUser consumer: subConsumers)
            consumer.subscribe(subscribers);
    }

    @Override
    public void unsubscribe(Observer subscriber){
        for (WaterUser consumer: subConsumers)
            consumer.unsubscribe(subscriber);
    }
    @Override
    public void replaceSource(Source source){
        for (WaterUser consumer : subConsumers){
            consumer.replaceSource(source);
        }
    }
    @Override
    public int getExpense() {
        updateExpense();
        return expense;
    }

    @Override
    public void updateExpense() {
        expense = 0;
        for (WaterUser consumer : subConsumers){
            expense +=consumer.getExpense();
        }
    }

    @Override
    public String getName() {
        if (name.equals(""))
            name = String.valueOf(hashCode());
        return name;
    }

    public void addConsumer(WaterUser consumer){
        subConsumers.add(consumer);
    }

}
