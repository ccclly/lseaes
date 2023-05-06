package com.cly.lseaes.dto;

import com.cly.lseaes.entity.Question;
import lombok.Data;

@Data
public class QuestionRepoDTO {
    private Question question;
    private Integer repositoryId;
}
