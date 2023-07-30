package main;

import util.Grade;

public class CourseGrade {
    private String courseDepartment;
    private int courseCode;
    private int courseCredit;
    private Grade gradeTaken;

    // All constructors call the fourth constructor, which has all the parameters of this class.
    // Empty fields in first three constructors are filled with default values.
    public CourseGrade(String courseDepartment) {
        this(courseDepartment, 100, 4, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode) {
        this(courseDepartment, courseCode, 4, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit) {
        this(courseDepartment, courseCode, courseCredit, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, Grade gradeTaken) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);
        setCourseCredit(courseCredit);
        setGradeTaken(gradeTaken);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, Double gradeTaken) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);
        setCourseCredit(courseCredit);
        setGradeTaken(gradeTaken);
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    // Course department is set as user input only if input matches the valid values. Else, default value is used.
    public void setCourseDepartment(String courseDepartment) {
        String[] validValues = {"CENG", "COMP", "ECE", "ME", "MATH"};
        for (int i = 0; i < validValues.length; i++) {
            if (courseDepartment.toUpperCase().equals(validValues[i])) {
                this.courseDepartment = courseDepartment;
                return;
            }
        }
        this.courseDepartment = "CENG";
    }

    public int getCourseCode() {
        return courseCode;
    }

    // Course code is set as user input only if input matches the valid values. Else, default value is used.
    public void setCourseCode(int courseCode) {
        if (courseCode >= 100 && courseCode <= 599) {
            this.courseCode = courseCode;
            return;
        }
        this.courseCode = 100;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    // Course credit is set as user input only if input matches the valid values. Else, default value is used.
    public void setCourseCredit(int courseCredit) {
        if (courseCredit == 3) {
            this.courseCredit = courseCredit;
            return;
        }
        this.courseCredit = 4;
    }

    public Grade getGradeTaken() {
        return gradeTaken;
    }

    // First setGradeTaken method accepts only enum values.
    public void setGradeTaken(Grade g) {
        this.gradeTaken = g;
    }

    // Second setGradeTaken method accepts double values and rounds them into integers, if the input is between the valid values.
    public void setGradeTaken(double val) {
        if (0 <= val && val <= 4) {
            int gradeRounded = (int) Math.round(val);
            for (Grade grade : Grade.values()) {
                if (grade.ordinal() == gradeRounded) {
                    this.gradeTaken = grade;
                    return;
                }
            }
        }
        this.gradeTaken = Grade.F;
    }

    @Override
    public String toString() {
        return "Department: " + courseDepartment + " CourseCode: " + courseCode + " Credit: " + courseCredit + " Grade: " + gradeTaken.name() + "\n";
    }
}
