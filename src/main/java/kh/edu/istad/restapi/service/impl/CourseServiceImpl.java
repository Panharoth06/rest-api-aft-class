package kh.edu.istad.restapi.service.impl;

import kh.edu.istad.restapi.domain.Course;
import kh.edu.istad.restapi.dto.CourseResponse;
import kh.edu.istad.restapi.dto.CreateCourseRequest;
import kh.edu.istad.restapi.mapper.CourseMapper;
import kh.edu.istad.restapi.repository.CourseRepository;
import kh.edu.istad.restapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<CourseResponse> getCourses(Boolean status) {

        return courseRepository.getCourseList().stream()
                .filter(course -> course.getStatus().equals(status))
                .map(CourseMapper::courseToCourseResponse).toList();

    }

    @Override
    public CourseResponse createCourse(CreateCourseRequest createCourseRequest) {

//        validate course code
        boolean isCodeExists = courseRepository
                .getCourseList()
                .stream()
                .anyMatch(course -> course.getCode().equals(createCourseRequest.code()));

        if (isCodeExists)
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Course code already exists");


        Course course = new Course();
        course.setCode(createCourseRequest.code());
        course.setPrice(createCourseRequest.price());
        course.setTitle(createCourseRequest.title());
        course.setId(UUID.randomUUID().toString());
        course.setStatus(true);

        courseRepository.getCourseList().add(course);

        return CourseMapper.courseToCourseResponse(course);
    }

    @Override
    public void deleteCourseByCode(String code) {

//        true, if any elements were removed
        if (!courseRepository.getCourseList().removeIf(course -> course.getCode().equals(code)))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Code does not exist");

    }
}
