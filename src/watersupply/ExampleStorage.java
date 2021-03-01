package watersupply;

public abstract class ExampleStorage {
    public static int MAXIMAL_PRESSURE = 12;// bar
    public static int MAXIMUM_EXTENSE = 5;
    public static void writeDebug(String Tag, String line){
        writeDebug(Tag+ ": " + line);
    }
    public static void writeDebug(String line){
        System.out.println("Debug/ "+line);
    }
    public static void endLine(){
        System.out.println();
    }
    public static void writeLogs(String[] logs){
        for(String line : logs)
            System.out.println("Log/ "+line);
    }
    public static double litersToM3(int liters){
        return  liters / 100;
    }
}
