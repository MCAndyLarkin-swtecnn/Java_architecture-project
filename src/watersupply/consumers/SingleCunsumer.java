package watersupply.consumers;


import watersupply.Hardware_realization;
import watersupply.odserver.Observer;

import static watersupply.ExampleStorage.*;

public class SingleCunsumer extends WaterUser{
    private Source source;

    public SingleCunsumer(Source source, int id){
        super("", id);
        this.source = source;
    }
    public SingleCunsumer(String name, Source source, int id){
        super(name, id);
        this.source = source;
    }

    @Hardware_realization
    public void changeExpense(){
        writeDebug("Single consumer - "+name, "Expense was changed");
        //Method must react to source.expense change
        notifySubscribers();
    }

    @Override
    public void replaceSource(Source source){
        this.source = source;
    }
    @Override
    public int getExpense() {
        updateExpense();
        return expense;
    }

    @Override
    public void updateExpense(){
        expense = source.getExpense(id);

        writeDebug("Generated expense/"+getName(), String.valueOf(expense));
    }
    @Override
    public String getName() {
        if (name.equals(""))
            name = String.valueOf(hashCode());
        return name;
    }
}
