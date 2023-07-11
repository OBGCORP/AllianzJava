package service;

import model.Branch;
import model.Instructor;
import model.Lecture;

public class LectureService {
    public Lecture createLecture(String name, Instructor instructor, Branch branch, int capacity) {
        Lecture lecture = new Lecture();
        lecture.setName(name);
        lecture.setInstructor(instructor);
        lecture.setBranch(branch);
        lecture.setCapacity(capacity);
        return lecture;
    }
}
