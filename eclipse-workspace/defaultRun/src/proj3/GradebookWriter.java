//**************************************************************************************************
// CLASS: GradebookWriter 
//
// DESCRIPTION
// Used to write student objects to a data file to update changes in student grades.
//
// AUTHOR
//Steven Kosanke
//skosanke
//skosanke@asu.edu
//**************************************************************************************************
package proj3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 * GradebookWriter inherits from PrintWriter and writes the gradebook info to the file whose name
 * is passed to the ctor.
 */
public class GradebookWriter extends PrintWriter {

    /**
     * Call the super class ctor that takes a String as the argument, i.e, PrintWriter(String).
     * The PrintWriter ctor opens the file named by pFname for writing. It will throw a
     * FileNotFoundException if the file could not be opened for writing. We throw the exception
     * here as well where it will eventually be caught in Main.exit() -- see SR 7.
     *
     * @param pFname The name of the output file to be opened for writing.
     */
	GradebookWriter(String pFname) throws FileNotFoundException {
		super(pFname); }
	
    

    /**
     * Writes the gradebook info to the output file which was opened in the ctor.
     * 
     * @param pRoster The roster of students.
     *
     * PSEUDOCODE:
     * method writeGradebook(pRoster : Roster() : void
     *     EnhancedFor each student in pRoster.getStudentList() Do
     *         Call println(student)
     *     End For
     *     Call close()
     * end writeGradebook
     */ 
		
    public void writeGradebook(Roster pRoster) {
    	for (int i=0; i< pRoster.getStudentList().size(); i++) {
    		print(pRoster.getStudentList().get(i).getLastName() + " " + pRoster.getStudentList().get(i).getFirstName() + " ");
    		for (int j = 0; j<pRoster.getStudentList().get(i).getExamList().size(); j++) {
    			print(pRoster.getStudentList().get(i).getExamList().get(j)+ " ");
    		}
    		for (int j = 0; j<pRoster.getStudentList().get(i).getHomeworkList().size(); j++) {
    			print(pRoster.getStudentList().get(i).getHomeworkList().get(j) + " ");
    		}
    		
    		println("");
    	}

}}
