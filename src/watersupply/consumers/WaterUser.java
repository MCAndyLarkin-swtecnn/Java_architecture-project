package watersupply.consumers;

import watersupply.odserver.Observable;

public abstract class WaterUser extends Observable {
    protected int expense = 0;
    protected String name;
    protected final int id;//adress

    protected WaterUser(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract int getExpense();//depression

    public abstract void updateExpense();

    public abstract String getName();

    public abstract void replaceSource(Source source);
}
