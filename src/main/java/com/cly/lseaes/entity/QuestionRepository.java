package com.cly.lseaes.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 试题题库关联
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
@TableName("question_repository")
public class QuestionRepository implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer questionId;

    private Integer repositoryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
    public Integer getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(Integer repositoryId) {
        this.repositoryId = repositoryId;
    }

    @Override
    public String toString() {
        return "QuestionRepository{" +
            "id=" + id +
            ", questionId=" + questionId +
            ", repositoryId=" + repositoryId +
        "}";
    }
}
