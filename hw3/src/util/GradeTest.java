package util;

public class GradeTest {
    public static void main(String[] args) {
        for (Grade grade : Grade.values()) {
            System.out.println(grade.toString());
        }
    }
}
