package service;

import model.Day;
import model.LectureScheduleTime;

public class LectureScheduleTimeService {
    public LectureScheduleTime createLectureScheduleTime(Day dayOfWeek, String time){
        LectureScheduleTime lectureScheduleTime = new LectureScheduleTime();
        lectureScheduleTime.setDayOfWeek(dayOfWeek);
        lectureScheduleTime.setTime(time);
        return lectureScheduleTime;
    }
}
