package watersupply.management;

import kotlin.ranges.CharRange;

import java.util.List;

public enum PowerGrades {
    Null("null"),
    Minimal("1"),
    Very_Low("2"),
    Low("3"),
    Lower_of_middle("4"),
    Average("5"),
    Higher_of_middle("6"),
    High("7"),
    Very_High("8"),
    Super_High("9"),
    Maximal("10");
    private String grade;
    PowerGrades(String grade){
        this.grade = grade;
    }
    String grade(){ return grade;}
//    static findByGrade(String )
}
