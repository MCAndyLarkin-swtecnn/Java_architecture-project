package watersupply.consumers;

public interface WaterUser {                                                                                            //Why Componovshik?
    int getExpense();//depression

    void updateExpense();

    String getName();

    void replaceSource(Source source);
}
