package com.cly.lseaes.dto;

import lombok.Data;

@Data
public class ProblemExamDTO {
    private Integer id;

    private String name;

    private Integer type;

    private String choiceA;

    private Boolean choiceAIsTrue;

    private String choiceB;

    private Boolean choiceBIsTrue;

    private String choiceC;

    private Boolean choiceCIsTrue;

    private String choiceD;

    private Boolean choiceDIsTrue;

    private String analysisDesc;

    private Integer appearCount;

    private Integer rightAnsCount;

    private Integer authorId;
    private Long selected;
}
