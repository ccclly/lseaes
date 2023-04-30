package com.cly.lseaes.dto;

import com.cly.lseaes.entity.User;
import lombok.Data;

@Data
public class UserExamDTO {
    private Integer id;

    private String name;

    private String grade;

    private String college;

    private String major;

    private Double score;

    private Long selected;
}
