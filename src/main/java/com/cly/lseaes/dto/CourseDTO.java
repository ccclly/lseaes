package com.cly.lseaes.dto;

import com.cly.lseaes.entity.Chapter;
import com.cly.lseaes.entity.Lesson;
import lombok.Data;

import java.util.List;

@Data
public class CourseDTO {
    private String name;

    private String description;

    private String imgName;

    private Integer authorId;

    private List<Chapter> chapterList;

    private List<Lesson> lessonList;
}
