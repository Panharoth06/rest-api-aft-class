package kh.edu.istad.restapi.mapper;

import kh.edu.istad.restapi.domain.Course;
import kh.edu.istad.restapi.dto.CourseResponse;
import kh.edu.istad.restapi.dto.CreateCourseRequest;

import java.util.UUID;

public class CourseMapper {

    public static CourseResponse courseToCourseResponse(Course course) {
        return CourseResponse
                .builder()
                .price(course.getPrice())
                .title(course.getTitle())
                .code(course.getCode())
                .build();
    }

}
