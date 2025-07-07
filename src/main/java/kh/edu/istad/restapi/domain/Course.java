package kh.edu.istad.restapi.domain;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    private String id;
    private String code;
    private String title;
    private Double price;
    private Boolean status;
}
