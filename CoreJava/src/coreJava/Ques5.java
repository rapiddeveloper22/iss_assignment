package coreJava;

/**
 * This program demonstrates the use of inheritance, polymorphism, encapsulation, and interfaces in Java.
 */
class Animal {
    public String sound = "No sound";

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        System.out.println(this.sound);
        return this.sound;
    }

    public void printClassName() {
        System.out.println("This is the Animal class");
    }
}

/**
 * Dog class inherits from Animal and overrides methods to demonstrate polymorphism.
 */
class Dog extends Animal {
    public void getSoundOfDog() {
        super.setSound("Bark");
        super.getSound();
    }
}

/**
 * Cat class inherits from Animal and overrides the printClassName method to demonstrate polymorphism.
 */
class Cat extends Animal {
    public void printClassName() {
        System.out.println("This is the Cat class");
    }
}

/**
 * Employee is an abstract class with encapsulated fields, and Salary extends Employee.
 */
abstract class Employee {
    private String name;
    private int age;

    public Employee(String name, double salary) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
}

/**
 * Salary class extends Employee and adds a salary field.
 */
class Salary extends Employee {
    private double salary;

    public Salary(String name, double salary, int age) {
        super(name, age);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

/**
 * Ques5 class demonstrates polymorphism with Animal, Dog, and Cat.
 */
public class Ques5 {

    public static void main(String[] args) {
        // Creating Dog and Cat instances and storing them in Animal references for polymorphism.
        Animal dog = new Dog();
        Animal cat = new Cat();
    }
}

/**
 * Mobile interface is implemented by the Blackberry class.
 */
interface Mobile {
    void printMobileName();
}

/**
 * Blackberry class implements the Mobile interface.
 */
class Blackberry implements Mobile {
    public void printMobileName() {
        System.out.println("This is a Blackberry mobile");
    }
}
