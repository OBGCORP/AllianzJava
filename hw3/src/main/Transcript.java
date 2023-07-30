package main;

import java.util.ArrayList;
import java.util.Locale;

public class Transcript {
    private int studentID;
    private ArrayList<CourseGrade> studentGrades;
    private double GPA;

    public Transcript(int studentID) {
        this.studentID = studentID;
        this.GPA = 0;
        this.studentGrades = new ArrayList<>();
    }

    // addCourseTaken method takes a CourseGrade object, add it to studentGrades list if input is not null
    // and then calculates the GPA.
    public void addCourseTaken(CourseGrade courseGrade) {
        if (courseGrade != null) {
            this.studentGrades.add(courseGrade);
            double gradeTotal = 0;
            for (CourseGrade studentGrade : this.studentGrades) {
                gradeTotal += (double) studentGrade.getGradeTaken().ordinal() / Double.valueOf(this.studentGrades.size());
            }
            this.GPA = gradeTotal;
        } else {
            System.err.println("ERROR: CourseGrade is null.");
        }
    }

    @Override
    public String toString() {
        return "Student ID: " + this.studentID + "\n" + this.studentGrades.toString()
                .replaceAll("\\[", "")
                    .replaceAll(", ", "")
                        .replaceAll("]", "")
                + "GPA: " + String.format(Locale.US, "%.2f", this.GPA) + "\n";
    }
}
