import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
              String[] subjects = {"Data Structure", "Discrete Mathematics", "English", "Object Oriented Programming", "Data Science"};
        int totalMarks = 0;
        int numberOfSubjects = subjects.length; 
        System.out.println( "Enter marks for ");

        for (int i = 0; i < numberOfSubjects; i++) {
 System.out.print( subjects[i] + ": ");
            int marks = scan.nextInt();
            if (marks < 0 || marks > 100) {
                try {
                    throw new Exception("PLEASE ENTER THE VALID MARKS!!!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    i--; 
                    continue;
                }
            }
            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / numberOfSubjects;
        char grade;
        if (averagePercentage >= 90) {
            grade = 'O';
        }
              else if (averagePercentage >= 80) {
            grade = 'A';
        } 
           else if (averagePercentage >= 70) {
            grade = 'B';
        } else if (averagePercentage >= 60) {
            grade = 'C';
        } 
          else if (averagePercentage >= 50)
                {
            grade = 'D';
          }
            else if (averagePercentage >= 40){
            grade = 'E';
        }     else
             {
            grade = 'F';
            }
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);

        scan.close();
    }
}
