

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    long rollNo;
    int total;
    double average;
    String grade;

    Student(String name, long rollNo, int total) {
        this.name = name;
        this.rollNo = rollNo;
        this.total = total;
        this.average = total / 5.0;

        if (average >= 90) grade = "A+";
        else if (average >= 80) grade = "A";
        else if (average >= 70) grade = "B";
        else if (average >= 60) grade = "C";
        else if (average >= 35) grade = "D";
        else grade = "F";
    }

    void display() {
        System.out.println("\nName: " + name);
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("Result: " + (average >= 35 ? "PASS" : "FAIL"));
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Roll Number: ");
                long rollNo = sc.nextLong();

                int total = 0;
                for (int i = 1; i <= 5; i++) {
                    System.out.print("Enter Subject " + i + " Marks: ");
                    int marks = sc.nextInt();

                    if (marks < 0 || marks > 100) {
                        System.out.println("Enter marks between 0 and 100.");
                        i--;
                        continue;
                    }
                    total += marks;
                }

                students.add(new Student(name, rollNo, total));
                System.out.println("Student Added Successfully!");

            } else if (choice == 2) {
                if (students.isEmpty()) {
                    System.out.println("No student records found.");
                } else {
                    for (Student s : students) {
                        s.display();
                    }
                }

            } else if (choice == 3) {
                System.out.print("Enter Roll Number to Search: ");
                long searchRoll = sc.nextLong();
                boolean found = false;

                for (Student s : students) {
                    if (s.rollNo == searchRoll) {
                        s.display();
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student Not Found!");
                }

            } else if (choice == 4) {
                System.out.println("Thank You!");
                break;

            } else {
                System.out.println("Invalid Choice!");
            }
        }

        sc.close();
    }
}
