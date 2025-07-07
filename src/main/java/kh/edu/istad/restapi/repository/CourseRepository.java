package kh.edu.istad.restapi.repository;

import kh.edu.istad.restapi.domain.Course;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Repository
public class CourseRepository {

    private final List<Course> courseList = new ArrayList<>();

    CourseRepository() {
        courseList.add(new Course("ISTAD-001", UUID.randomUUID().toString(), "Spring Framework", 100.0, true));
        courseList.add(new Course("ISTAD-002", UUID.randomUUID().toString(), "Next Js", 90.0, true));
        courseList.add(new Course("ISTAD-003", UUID.randomUUID().toString(), "Linux Server", 80.0, false));
    }


}
