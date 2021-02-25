package watersupply.consumers;

import watersupply.ExampleStorage;

public class SingleCunsumer implements WaterUser{
    private final Source source;
    private int expense = 0;
    private final String name;

    public SingleCunsumer(Source source){
        name = String.valueOf(hashCode());
        this.source = source;
    }
    public SingleCunsumer(String name, Source source){
        this.source = source;
        this.name = name;
    }
    @Override
    public int getExpense() {
        updateExpense();
        return expense;
    }

    @Override
    public void updateExpense(){
        expense = source.getExpense();

        ExampleStorage.writeDebug("Generated expense/"+name, String.valueOf(expense));
    }
    @Override
    public String getName() {
        return name;
    }
}
