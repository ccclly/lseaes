package com.cly.lseaes.dto;

import com.cly.lseaes.entity.Course;
import lombok.Data;

@Data
public class RecordDTO {
    private Course course;
    private Integer process;
}
