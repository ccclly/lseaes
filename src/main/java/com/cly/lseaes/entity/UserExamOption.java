package com.cly.lseaes.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cly
 * @since 2023-04-26
 */
@TableName("user_exam_option")
public class UserExamOption implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer examId;

    private Integer problemId;

    private Boolean choiceAIsTrue;

    private Boolean choiceBIsTrue;

    private Boolean choiceCIsTrue;

    private Boolean choiceDIsTrue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }
    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }
    public Boolean getChoiceAIsTrue() {
        return choiceAIsTrue;
    }

    public void setChoiceAIsTrue(Boolean choiceAIsTrue) {
        this.choiceAIsTrue = choiceAIsTrue;
    }
    public Boolean getChoiceBIsTrue() {
        return choiceBIsTrue;
    }

    public void setChoiceBIsTrue(Boolean choiceBIsTrue) {
        this.choiceBIsTrue = choiceBIsTrue;
    }
    public Boolean getChoiceCIsTrue() {
        return choiceCIsTrue;
    }

    public void setChoiceCIsTrue(Boolean choiceCIsTrue) {
        this.choiceCIsTrue = choiceCIsTrue;
    }
    public Boolean getChoiceDIsTrue() {
        return choiceDIsTrue;
    }

    public void setChoiceDIsTrue(Boolean choiceDIsTrue) {
        this.choiceDIsTrue = choiceDIsTrue;
    }

    @Override
    public String toString() {
        return "UserExamOption{" +
            "id=" + id +
            ", userId=" + userId +
            ", examId=" + examId +
            ", problemId=" + problemId +
            ", choiceAIsTrue=" + choiceAIsTrue +
            ", choiceBIsTrue=" + choiceBIsTrue +
            ", choiceCIsTrue=" + choiceCIsTrue +
            ", choiceDIsTrue=" + choiceDIsTrue +
        "}";
    }
}
