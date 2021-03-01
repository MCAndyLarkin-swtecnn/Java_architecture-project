package watersupply.consumers;

public class TestSource implements Source {
    int currentExpense;
    SingleCunsumer cunsumer;
    public TestSource(int startExpense, SingleCunsumer consumer){
        currentExpense = startExpense;
        this.cunsumer = consumer;
    }

    public void setCurrentExpense(int currentExpense) {//Imitation of turn off/on
        this.currentExpense = currentExpense;
        cunsumer.changeExpense();
    }
    @Override
    public int getExpense(int id) {
        return currentExpense;
    }
}
