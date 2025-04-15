// Base class Person
class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Interface for grade calculation
interface GradeCalculation {
    String calculateGrade(int score);
}

// Course class
class Course {
    String courseName;
    String courseCode;
    int credits;

    public Course(String courseName, String courseCode, int credits) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
    }

    public void displayCourse() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Code: " + courseCode);
        System.out.println("Credits: " + credits);
    }
}

// Derived class Learner
class Learner extends Person implements GradeCalculation {
    static int totalLearners = 0;
    Course course;
    int marks;

    public Learner(String name, int id, Course course, int marks) {
        super(name, id);
        this.course = course;
        this.marks = marks;
        totalLearners++;
    }

    public void showDetails() {
        super.display();
        course.displayCourse();
        System.out.println("Grade: " + calculateGrade(marks));
    }

    public String calculateGrade(int score) {
        if (score >= 90) return "A";
        else if (score >= 75) return "B+";
        else if (score >= 60) return "B";
        else if (score >= 45) return "C";
        else return "F";
    }
}

// Main class
public class LearnerManagementSystem {
    public static void main(String[] args) {
        Course c1 = new Course("Data Structures", "DS101", 4);
        Course c2 = new Course("Java Programming", "JAVA201", 3);

        Learner l1 = new Learner("Priya Sharma", 201, c1, 92);
        Learner l2 = new Learner("Raj Verma", 202, c2, 78);

        System.out.println("------ Student-Course Management System Output ------");
        l1.showDetails();
        System.out.println("-----------------------------------------------------");
        l2.showDetails();
        System.out.println("-----------------------------------------------------");

        System.out.println("Total Learners: " + Learner.totalLearners);
    }
}
