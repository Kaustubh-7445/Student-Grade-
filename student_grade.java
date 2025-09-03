import java.util.ArrayList;
import java.util.Scanner;

class Student 
{
    String name;
    double grade;

    Student(String name, double grade) 
    {
        this.name = name;
        this.grade = grade;
    }
}

public class student_grade 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=== Student Grade Tracker ===");

        
        while (true) 
        {
            System.out.print("Enter student name (or type 'done' to finish): ");
            String name = sc.nextLine();

            if (name.equalsIgnoreCase("done")) 
            break;

            System.out.print("Enter grade for " + name + ": ");
            double grade = sc.nextDouble();
            sc.nextLine(); 

            students.add(new Student(name, grade));
        }

        
        if (students.isEmpty()) 
        {
            System.out.println("No students entered. Exiting...");
            return;
        }

        
        double sum = 0;
        double highest = students.get(0).grade;
        double lowest = students.get(0).grade;
        String topStudent = students.get(0).name;
        String lowStudent = students.get(0).name;

        for (Student s : students) 
        {
            sum += s.grade;
            if (s.grade > highest) 
            {
                highest = s.grade;
                topStudent = s.name;
            }
            if (s.grade < lowest) 
            {
                lowest = s.grade;
                lowStudent = s.name;
            }
        }

        double average = sum / students.size();

       
        System.out.println("\n=== Summary Report ===");
        for (Student s : students) 
        {
            System.out.println(s.name + " : " + s.grade);
        }

        System.out.println("----------------------------");
        System.out.println("Class Average : " + average);
        System.out.println("Highest Score : " + highest + " ( " + topStudent + " )");
        System.out.println("Lowest Score  : " + lowest + " ( " + lowStudent + " )");

        sc.close();
    }
}
