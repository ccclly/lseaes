package com.cly.lseaes.dto;

import lombok.Data;

import java.util.List;

@Data
public class PaperAnsDTO {
    private Integer paperId;
    private Integer questionId;
    private List<Integer> ansIds;
}
