package com.cly.lseaes.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer id;
    private String name;        //课程名称
    private String desc;        //题目描述
    private Admin author;       //作者
    private String content;     //内容
}
