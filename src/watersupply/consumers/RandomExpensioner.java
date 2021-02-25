package watersupply.consumers;

import watersupply.ExampleStorage;

import java.util.Random;

public class RandomExpensioner implements Source{
    @Override
    public int getExpense(int id) {
        return new Random().nextInt(ExampleStorage.MAXIMUM_EXTENSE);
    }
}
