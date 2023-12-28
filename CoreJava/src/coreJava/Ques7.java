package coreJava;

import java.util.*;

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private int score;

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student other) {
        // Implementing Comparable based on ID
        return Integer.compare(this.id, other.id);
    }

    // Custom Comparator for sorting based on Score
    public static Comparator<Student> scoreComparator = Comparator.comparingInt(Student::getScore);
}

public class Ques7 {

    public static void main(String[] args) {
        // Create a List of Students
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Alice", 85));
        studentList.add(new Student(3, "Charlie", 78));
        studentList.add(new Student(2, "Bob", 90));

        // Sorting the List of Students based on IDs using Comparable
        Collections.sort(studentList);

        // Displaying sorted List of Students based on ID
        System.out.println("Sorted List of Students based on ID (using Comparable):");
        for (Student student : studentList) {
            System.out.println(student);
        }

        // Sorting the List of Students based on Scores using Comparator
        studentList.sort(Student.scoreComparator);

        // Displaying sorted List of Students based on Score
        System.out.println("\nSorted List of Students based on Score (using Comparator):");
        for (Student student : studentList) {
            System.out.println(student);
        }

        // Create a Set of Students
        Set<Student> studentSet = new TreeSet<>();
        studentSet.add(new Student(1, "Alice", 85));
        studentSet.add(new Student(3, "Charlie", 78));
        studentSet.add(new Student(2, "Bob", 90));

        // Displaying sorted Set of Students based on ID (using Comparable)
        System.out.println("Sorted Set of Students based on ID (using Comparable):");
        for (Student student : studentSet) {
            System.out.println(student);
        }

        // Create a Map with Students as keys and values
        Map<Integer, Student> studentMap = new TreeMap<>();
        studentMap.put(1, new Student(1, "Alice", 85));
        studentMap.put(3, new Student(3, "Charlie", 78));
        studentMap.put(2, new Student(2, "Bob", 90));

        // Displaying sorted Map of Students based on ID (using Comparator)
        System.out.println("\nSorted Map of Students based on ID (using Comparator):");
        List<Map.Entry<Integer, Student>> entryList = new ArrayList<>(studentMap.entrySet());
        entryList.sort(Comparator.comparingInt(Map.Entry::getKey));
        for (Map.Entry<Integer, Student> entry : entryList) {
            System.out.println("ID: " + entry.getKey() + ", Student: " + entry.getValue());
        }

        // Create a Map with Students as keys and values, sorting by Score (using Comparator)
        Map<Student, String> studentScoreMap = new TreeMap<>(Student.scoreComparator);
        studentScoreMap.put(new Student(1, "Alice", 85), "Math");
        studentScoreMap.put(new Student(3, "Charlie", 78), "Science");
        studentScoreMap.put(new Student(2, "Bob", 90), "History");

        // Displaying sorted Map of Students based on Score
        System.out.println("\nSorted Map of Students based on Score (using Comparator):");
        for (Map.Entry<Student, String> entry : studentScoreMap.entrySet()) {
            System.out.println("Student: " + entry.getKey() + ", Subject: " + entry.getValue());
        }
    }
}
