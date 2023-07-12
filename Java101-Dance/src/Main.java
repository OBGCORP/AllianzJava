import model.DanceCourse;
import service.DanceCourseService;

public class Main {


    public static void main(String[] args) {

        DanceCourseService danceCourseService = new DanceCourseService();
        DanceCourse danceCourse = danceCourseService.createDanceCourse();
        danceCourse.setName("Deneme");
        danceCourse.setTaxNumber("68723623823");
        DanceCourse danceCourse1 = danceCourseService.createDanceCourse("Deneme");
        danceCourse1.setName("Deneme2");
        DanceCourse danceCourse2 = danceCourseService.createDanceCourse("Deneme", "68723623823", "Ankara");

    }
}