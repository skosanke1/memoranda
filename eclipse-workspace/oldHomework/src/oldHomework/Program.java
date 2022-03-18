package oldHomework;
/*-------------------------------------------------------------
//AUTHOR: Steven Kosanke
//FILENAME: Program.java
//SPECIFICATION: Program for the Autograder file
//FOR: CSE110 Lab 7
//-----------------------------------------------------------*/

import java.time.LocalDateTime;

public class Program {
    private String programName, description, createdDate, fileName;
    private Student author;

    public Program(String programName, String description, String fileName, Student author) {
        this.programName = programName;
        this.description = description;
        this.fileName = fileName;
        this.author = author;
        this.createdDate = LocalDateTime.now().toString();
    }

    public String toString() {
        return String.format("Program: %s, Desc: %s, Filename: %s, Author: %s",
                programName, description, fileName, author.toString());
    }

    public String getProgramName() {
        return programName;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getFileName() {
        return fileName;
    }

    public Student getAuthor() {
        return author;
    }
}
