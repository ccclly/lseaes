package com.cly.lseaes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
    private Integer id;
    private String name;
    private Date start;
    private Date end;
    private Date duration;
    private Admin publisher;         //发布者
}
