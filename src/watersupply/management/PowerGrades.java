package watersupply.management;

public enum PowerGrades {
    Null("null", 0),
    Minimal("1",1),
    Very_Low("2",2),
    Low("3",4),
    Lower_of_middle("4",8),
    Average("5",16),
    Higher_of_middle("6",32),
    High("7",64),
    Very_High("8",128),
    Super_High("9",256),
    Maximal("10",512);
    private String grade;
    private int powerfull;
    PowerGrades(String grade, int powerful){
        this.grade = grade;//index
        this.powerfull = powerful;// liters/sec
    }
    String grade(){ return grade;}
    int powerful(){ return powerfull;}
}
