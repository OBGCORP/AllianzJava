package service;

import model.DanceCourse;

public class DanceCourseService {

    public DanceCourse createDanceCourse(String name, String address, String founder, String taxNumber, String taxOffice) {
        DanceCourse danceCourse = new DanceCourse();
        danceCourse.setName(name);
        danceCourse.setAddress(address);
        danceCourse.setFounder(founder);
        danceCourse.setTaxNumber(taxNumber);
        danceCourse.setTaxOffice(taxOffice);
        return danceCourse;
    }

    public DanceCourse createDanceCourse() {
        DanceCourse danceCourse = new DanceCourse();
        return danceCourse;
    }

    public DanceCourse createDanceCourse(String name) {
        return new DanceCourse(name);
    }

    public DanceCourse createDanceCourse(String name, String taxNumber, String taxOffice) {
        return new DanceCourse(name, taxNumber, taxOffice);
    }

}
