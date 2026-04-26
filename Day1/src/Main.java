public class Main {
    public static void main(String[] args){
        String name;
        int age;
        double height;
        boolean knowsEnglish;

        name = "Artem";
        age = 22;
        height = 186.5;
        knowsEnglish = true;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("English: " + knowsEnglish);

        Person p1 = new Person("Dima", 21, "Saint Petersburg","Educator");
        Person p2 = new Person("Andrew", 31, "Berlin","Engineer");
        p1.introduce();
        p2.introduce();
    }
}

class Person {
    String name;
    int age;
    String city;
    String profession;

    Person(String name, int age, String city, String profession) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.profession = profession;
    }
    void introduce(){
        System.out.println("Hi, my name is " + name + "\nI am "+ age + " years old\n" + "I live in " + city +"\nMy profession is " + profession);
    }
}

