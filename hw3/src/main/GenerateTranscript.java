package main;

import java.util.Scanner;

public class GenerateTranscript {

    public void takeInputFromUser() {
        Scanner sc = new Scanner(System.in);
        int studentID = -1;
        while (true) {
            try {
                System.out.println("Enter Student Id:");
                studentID = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        while (sc.hasNext()) {

        }
    }
}
