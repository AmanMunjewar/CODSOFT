import java.io.Serializable;

public class Student implements Serializable{
    private int roll;
    private String name;
    private int grade;

    public Student(int roll, String name, int grade) {
        this.roll = roll;
        this.name = name;
        this.grade = grade;
    }

    public void displayInfo(){
        System.out.println(String.format("%4d %7s %6d", roll, name, grade));
    }

    public int getRoll() {
        return roll;
    }
    
}
