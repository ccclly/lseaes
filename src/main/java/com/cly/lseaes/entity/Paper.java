package com.cly.lseaes.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
public class Paper implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer examId;

    private Integer userId;

    private String name;

    /**
     * 试卷状态
     */
    private Integer state;

    /**
     * 用户得分
     */
    private Double userScore;

    /**
     * 考试时长
     */
    private Integer totalTime;
    private Boolean isTest;
//    private Boolean test;



    private LocalDateTime createAt;

    private LocalDateTime updateAt;
    public Boolean getIsTest() {
        return isTest;
    }

    public void setIsTest(Boolean isTest) {
        this.isTest = isTest;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }
    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Paper{" +
            "id=" + id +
            ", examId=" + examId +
            ", userId=" + userId +
            ", state=" + state +
            ", userScore=" + userScore +
            ", totalTime=" + totalTime +
            ", createAt=" + createAt +
            ", updateAt=" + updateAt +
        "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//
//    public Boolean getTest() {
//        return test;
//    }
//
//    public void setTest(Boolean test) {
//        this.test = test;
//    }

    public void setUserScore(Double userScore) {
        this.userScore = userScore;
    }

    public Double getUserScore() {
        return userScore;
    }
}
