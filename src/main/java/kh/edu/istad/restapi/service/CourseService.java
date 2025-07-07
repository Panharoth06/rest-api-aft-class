package kh.edu.istad.restapi.service;

import kh.edu.istad.restapi.dto.CourseResponse;
import kh.edu.istad.restapi.dto.CreateCourseRequest;

import java.util.List;

public interface CourseService {


    /**
     * <p> This method will get all courses based on {@code status}  </p>
     * @author Chheng Panharoth
     */
    List<CourseResponse> getCourses(Boolean status);



    /**
     * <p>This method for creating a new course </p>
     * @param createCourseRequest data from client
     * @return CourseResponse
     * @author Chheng Panharoth
     */
    CourseResponse createCourse(CreateCourseRequest createCourseRequest);

// assignment for Monday
//    response nothing
//    data processing with code
//    use for delete course by course code
//    void deleteCourseByCode(String code);
//    if code does not exist, show message code does not exist (404)

    /**
     * <p>This method is for deleting course by {@code code}</p>
     * @param code data from client
     * @author Chheng Panharoth
     */
    void deleteCourseByCode (String code);
}
