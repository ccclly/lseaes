package com.cly.lseaes.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 试题主表
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 题目ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 题目类型
     */
    private Integer type;

    private String name;

    private String imgName;

    private String analysisDesc;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
    public String getAnalysisDesc() {
        return analysisDesc;
    }

    public void setAnalysisDesc(String analysisDesc) {
        this.analysisDesc = analysisDesc;
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
        return "Question{" +
            "id=" + id +
            ", type=" + type +
            ", name=" + name +
            ", imgName=" + imgName +
            ", analysisDesc=" + analysisDesc +
            ", createAt=" + createAt +
            ", updateAt=" + updateAt +
        "}";
    }
}
