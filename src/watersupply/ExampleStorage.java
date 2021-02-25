package watersupply;

public abstract class ExampleStorage {
    public static int MAXIMUM_EXTENSE = 10000;
    public static void writeDebug(String Tag, String line){
        writeDebug(Tag+ ": " + line);
    }
    public static void writeDebug(String line){
        System.out.println("Debug/ "+line);
    }
}
