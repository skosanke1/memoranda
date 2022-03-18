package oldHomework;
/*-------------------------------------------------------------
//AUTHOR: Steven Kosanke
//FILENAME: Student.java
//SPECIFICATION: Student Program for Lab7.
//FOR: CSE110 Lab 08
//-----------------------------------------------------------*/

public class Student {
	private String sFirstName, sLastName, sFullName, sAsuID = "";
    private double sGrade; private int numOfUpdates = 0; private int numOfAccessed = 0; 
    
    //Different ways of generating a Student profile
    public Student(String sFullName, String sAsuID, double sGrade) 
    {

        this.sFullName = sFullName;
        this.sAsuID = sAsuID;
        this.sGrade = -1;
    }
    public Student() 
    {

    }
    public Student(String aa) 
    {
    	this.sFullName = sFullName;
    }
   
    public String toString() 
    {
        return String.format("Full Name: %s, AsuID: %s, Grade: %1f",
        		sFullName, sAsuID, sGrade);
    }

    
    //Getter methods 
    public String getFirstName() {
    	numOfUpdates++;
    	return sFirstName;   
    }

    public String getLastName() {
    	numOfAccessed++;
        return sLastName;
    }

    public String getFullname() {
    	numOfAccessed++;
        return sFullName;
    }

    public String getAsuID() {
    	numOfAccessed++;
        return sAsuID;
    }

    public double getGrade() {
    	numOfAccessed++;
        return sGrade;
    }
   
	public int getNumOfUpdates()
	{
		numOfAccessed++;
		return numOfUpdates;
	}
	
	public int getNumOfAccessed()
	{
		numOfAccessed++;
		return numOfAccessed;
	}
	
    //Setter Methods
    public void setName(String x) {
    	numOfUpdates++;
    	this.sFullName = x;
    }    
    public void setGrade(double x) {
    	numOfUpdates++;
        this.sGrade = x;
    }
    public void setId(String x) {
    	numOfUpdates++;
        this.sAsuID = x;
    }
    
//Comparing method
	public boolean equals(Student aa)
	{boolean condition = false;
		String a = aa.sAsuID; 
		String b = "10291029";
		String c = aa.sFullName.toUpperCase();
		String d = "FOO BAR";
		
		if (a.equals(b))
		{
			condition = true;
		}
		if (c.equals(d))
		{
			condition = true;
		}
		else
			condition = false;
		numOfAccessed++;
		return condition;
	}
}
