package util;

public class GradeTest {
    // This class was created to test Grade Enum.
    public static void main(String[] args) {
        for (Grade grade : Grade.values()) {
            System.out.println(grade.toString());
        }
    }
}
