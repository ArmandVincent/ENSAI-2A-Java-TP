package fr.ensai.library;

public class Student extends Person {
    private String name;
    private int age;
    private int academicYear;
    private boolean isClassDelegate;

    public Student(String name, int age, int academicYear, boolean isClassDelegate){
        this.academicYear = academicYear;
        this.name = name;
        this.age = age;
        this.isClassDelegate = isClassDelegate;
    }
}
