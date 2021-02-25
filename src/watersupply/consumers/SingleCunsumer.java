package watersupply.consumers;

import static watersupply.ExampleStorage.*;

public class SingleCunsumer implements WaterUser{
    private int id;//adress
    private Source source;
    private int expense = 0;
    private final String name;

    public SingleCunsumer(Source source, int id){
        name = String.valueOf(hashCode());
        this.source = source;
        this.id = id;
    }
    public SingleCunsumer(String name, Source source, int id){
        this.source = source;
        this.name = name;
        this.id = id;
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

        writeDebug("Generated expense/"+name, String.valueOf(expense));
    }
    @Override
    public String getName() {
        return name;
    }
}
