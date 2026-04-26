public class Main {
    public static void main(String[] args) {
    Student s1 = new Student("Michael", 16, 9);
    s1.showInfo();
    s1.setAge(-20);
    }
}

class Student{
    private String name;
    private  int age;
    private double grade;

    Student(String name, int age, double grade){
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0 && age < 120) {
            this.age = age;
        }
        else {
            System.out.println("Wrong age. Age can not be less 0 and more 120");
        }
    }

    public void setGrade(double grade) {
        if (grade > 0 && grade < 12) {
            this.grade = grade;
        }
        else {
            System.out.println("Wrong grade. Age can not be less 0 and more 12");
        }
    }

    public void showInfo(){
        System.out.println("Student: " + name +"\nAge: " + age + "\nGrade: " + grade);
    }
}