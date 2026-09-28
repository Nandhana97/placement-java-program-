import java.util.*;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    int total() {
        int sum = 0;
        for (int mark : marks)
            sum += mark;
        return sum;
    }

    char grade() {
        double avg = total() / (double) marks.length;
        if (avg >= 90) return 'A';
        if (avg >= 80) return 'B';
        if (avg >= 70) return 'C';
        if (avg >= 60) return 'D';
        return 'F';
    }
}

public class StudentGradeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        try {
            System.out.print("Enter number of students: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {
                System.out.print("\nEnter student name: ");
                String name = sc.nextLine();

                int[] marks = new int[3];
                for (int j = 0; j < 3; j++) {
                    System.out.print("Enter mark " + (j + 1) + ": ");
                    marks[j] = sc.nextInt();
                }
                sc.nextLine();
                students.add(new Student(name, marks));
            }

            System.out.println("\n--- Student Results ---");
            for (Student s : students) {
                System.out.println("Name: " + s.name);
                System.out.println("Total: " + s.total());
                System.out.println("Grade: " + s.grade());

                switch (s.grade()) {
                    case 'A' -> System.out.println("Excellent!");
                    case 'B' -> System.out.println("Very Good!");
                    case 'C' -> System.out.println("Good!");
                    default -> System.out.println("Keep improving!");
                }
                System.out.println();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numbers.");
        }

        sc.close();
    }
}
