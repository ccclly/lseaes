package com.cly.lseaes.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 试题答案选项
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
@TableName("question_answer")
public class QuestionAnswer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 问题ID
     */
    private Integer questionId;

    /**
     * 是否正确
     */
    private Boolean isRight;

    private String imgName;

    private String name;

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
    public Boolean getIsRight() {
        return isRight;
    }

    public void setIsRight(Boolean isRight) {
        this.isRight = isRight;
    }
    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "QuestionAnswer{" +
            "id=" + id +
            ", questionId=" + questionId +
            ", isRight=" + isRight +
            ", imgName=" + imgName +
            ", name=" + name +
        "}";
    }
}
