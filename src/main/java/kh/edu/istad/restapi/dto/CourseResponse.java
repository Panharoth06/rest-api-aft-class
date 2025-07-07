package kh.edu.istad.restapi.dto;

import lombok.Builder;

@Builder
public record CourseResponse(
        String code,
        String title,
        Double price
) { }
