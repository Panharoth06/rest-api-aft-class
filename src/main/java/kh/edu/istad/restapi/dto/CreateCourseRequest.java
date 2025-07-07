package kh.edu.istad.restapi.dto;

public record CreateCourseRequest(
      String code,
      String title,
      Double price
) { }
