package main;

import util.Grade;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GenerateTranscript {

    private Transcript transcript;
    private CourseGrade courseGrade;

    public void takeInputFromUser() {
        Scanner sc = new Scanner(System.in);
        int studentID = -1;
        System.out.println("Enter Student Id:");
        studentID = sc.nextInt();
        transcript = new Transcript(studentID);
        try {
            while (sc.hasNextLine()) {
                sc.nextLine();
                System.out.print("Enter Department: ");
                String courseDepartment = sc.nextLine();
                System.out.print("Enter Course Code: ");
                int courseCode = sc.nextInt();
                System.out.print("Enter Credit: ");
                int courseCredit = sc.nextInt();
                System.out.print("Enter Grade: ");
                double grade = sc.nextDouble();
                CourseGrade courseGrade = new CourseGrade(courseDepartment.toUpperCase(), courseCode, courseCredit, grade);
                transcript.addCourseTaken(courseGrade);
            }
        } catch (Exception e) {

        }
        System.out.println(transcript);
    }

    public void takeInputFromFile() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter filename: ");
        String filename = sc.nextLine();

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String lineRead = reader.readLine();
        int studentID = Integer.valueOf(lineRead);
        Transcript transcript = new Transcript(studentID);
        ArrayList<String> rawInput = new ArrayList<>();

        while ((lineRead = reader.readLine()) != null) {
            for (String str : lineRead.split(" ")) {
                rawInput.add(str);
            }
        }

        String courseDepartment = "";
        int courseCode = -1;
        int courseCredit = -1;
        double gradeTaken;
        for (int i = 0; i < rawInput.size(); i++) {
            if (((i + 1) % 4) == 1) {
                courseDepartment = rawInput.get(i);
            } else if (((i + 1) % 4) == 2) {
                courseCode = Integer.valueOf(rawInput.get(i));
            } else if (((i + 1) % 4) == 3) {
                courseCredit = Integer.valueOf(rawInput.get(i));
            } else if (((i + 1) % 4) == 0) {
                gradeTaken = Double.valueOf(rawInput.get(i));
                transcript.addCourseTaken(new CourseGrade(courseDepartment, courseCode, courseCredit, gradeTaken));
            }

        }

        System.out.println(transcript);
        sc.close();
    }
}
