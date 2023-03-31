package com.cly.lseaes.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problem {
    private Integer id;
    private String desc;        //题目描述
    private Integer type;           //题目类型：0单选，1多选，2判断
    private String choice;     //选项
    private String ans;         //正确答案
    private Double Accuracy;       //正确率
    private String analysisDesc;//解析
    private Admin author;       //作者
}
