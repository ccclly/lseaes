package com.cly.lseaes.dto;

import com.cly.lseaes.entity.Course;
import com.cly.lseaes.entity.EnterPermit;
import com.cly.lseaes.entity.Exam;
import lombok.Data;

@Data
public class EnterDTO {
    private EnterPermit enterPermit;
    private Exam exam;
    private Boolean examPass;
    private Course course;
    private Boolean coursePass;
}
