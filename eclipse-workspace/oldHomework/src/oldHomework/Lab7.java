package oldHomework;
/*-------------------------------------------------------------
  // AUTHOR: Steven Kosanke
  // FILENAME: Autograding Program
  // SPECIFICATION: User inputs students info and program saves grade info
  // FOR: CSE 110-Lab 7
  // TIME SPENT: 4 hours 
//-----------------------------------------------------------*/
import java.util.Scanner;
public class Lab7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName, lastName, asuid;
        double grade;
        String programName, description, fileName;

        // Input user data
        println("The student's first name?");
        firstName = scan.nextLine();
        println("The student's last name?");
        lastName = scan.nextLine();
        println("The student's ASU ID?");
        asuid = scan.nextLine();
        println("Program name?");
        programName = scan.nextLine();
        println("Program desc?");
        description = scan.nextLine();
        println("Program filename?");
        fileName = scan.nextLine();
        println("Program grade?");
        grade = scan.nextDouble(); //scan.nextLine();
        println(""); scan.close();

        // Create a Student object
        Student student1 = new Student(firstName, lastName, asuid, grade);
        System.out.println("Making a student record\n...[" + student1 + "]");

        student1.setGrade(grade);

        // Create a Program object 
        Program program1 = new Program(programName, description, fileName, student1);
        System.out.println("Making a program record\n...[" + program1 + "]");

        // Invoke makeReport to show the report
        makeReport(program1);
    }

    private static void makeReport(Program program) {
        println("\n========== Program Submission Detail ==========");
        pprint("Student", program.getAuthor().getFullName());
        pprint("ASU ID", program.getAuthor().getAsuID());
        pprint("Grade", "" + program.getAuthor().getGrade());
        println("");
        pprint("Program", program.getProgramName());
        pprint("Filename", program.getFileName());
        pprint("Description", program.getDescription());
        pprint("Datetime", program.getCreatedDate());
    }

    private static void pprint(String key, String value) {
        println(String.format("%-12s: %-10s", key, value));
    }

    private static void println(String s) {
        System.out.println(s);
    }
}
