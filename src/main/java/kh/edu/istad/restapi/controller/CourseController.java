package kh.edu.istad.restapi.controller;

import kh.edu.istad.restapi.dto.CourseResponse;
import kh.edu.istad.restapi.dto.CreateCourseRequest;
import kh.edu.istad.restapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<CourseResponse> getCourses(@RequestParam(required = false, defaultValue = "true") Boolean status) {
        return courseService.getCourses(status);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse createCourse(@RequestBody CreateCourseRequest createCourseRequest) {
        return courseService.createCourse(createCourseRequest);
    }

    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable String code) {
        courseService.deleteCourseByCode(code);
    }

}
