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
 * @since 2023-04-18
 */
public class Problem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public String getChoiceA() {
        return choiceA;
    }

    public void setChoiceA(String choiceA) {
        this.choiceA = choiceA;
    }
    public Boolean getChoiceAIsTrue() {
        return choiceAIsTrue;
    }

    public void setChoiceAIsTrue(Boolean choiceAIsTrue) {
        this.choiceAIsTrue = choiceAIsTrue;
    }
    public String getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(String choiceB) {
        this.choiceB = choiceB;
    }
    public Boolean getChoiceBIsTrue() {
        return choiceBIsTrue;
    }

    public void setChoiceBIsTrue(Boolean choiceBIsTrue) {
        this.choiceBIsTrue = choiceBIsTrue;
    }
    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }
    public Boolean getChoiceCIsTrue() {
        return choiceCIsTrue;
    }

    public void setChoiceCIsTrue(Boolean choiceCIsTrue) {
        this.choiceCIsTrue = choiceCIsTrue;
    }
    public String getChoiceD() {
        return choiceD;
    }

    public void setChoiceD(String choiceD) {
        this.choiceD = choiceD;
    }
    public Boolean getChoiceDIsTrue() {
        return choiceDIsTrue;
    }

    public void setChoiceDIsTrue(Boolean choiceDIsTrue) {
        this.choiceDIsTrue = choiceDIsTrue;
    }
    public String getAnalysisDesc() {
        return analysisDesc;
    }

    public void setAnalysisDesc(String analysisDesc) {
        this.analysisDesc = analysisDesc;
    }
    public Integer getAppearCount() {
        return appearCount;
    }

    public void setAppearCount(Integer appearCount) {
        this.appearCount = appearCount;
    }
    public Integer getRightAnsCount() {
        return rightAnsCount;
    }

    public void setRightAnsCount(Integer rightAnsCount) {
        this.rightAnsCount = rightAnsCount;
    }
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
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
        return "Problem{" +
            "id=" + id +
            ", name=" + name +
            ", type=" + type +
            ", choiceA=" + choiceA +
            ", choiceAIsTrue=" + choiceAIsTrue +
            ", choiceB=" + choiceB +
            ", choiceBIsTrue=" + choiceBIsTrue +
            ", choiceC=" + choiceC +
            ", choiceCIsTrue=" + choiceCIsTrue +
            ", choiceD=" + choiceD +
            ", choiceDIsTrue=" + choiceDIsTrue +
            ", analysisDesc=" + analysisDesc +
            ", appearCount=" + appearCount +
            ", rightAnsCount=" + rightAnsCount +
            ", authorId=" + authorId +
            ", createAt=" + createAt +
            ", updateAt=" + updateAt +
        "}";
    }
}
