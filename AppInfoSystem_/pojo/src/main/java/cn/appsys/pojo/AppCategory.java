package cn.appsys.pojo;

import java.time.LocalDateTime;

/**
 * @author XRZ
 * @date 2019\3\3 0003
 * @Description :
 */
public class AppCategory {

    private Integer id;
    private String categoryCode;//分类编码
    private String categoryName;//分类名称
    private Integer parentId;//父级节点id
    private Integer createdBy; //创建者（来源于backend_user用户表的用户id）
    private LocalDateTime creationDate; //创建时间
    private Integer modifyBy; //更新者（来源于backend_user用户表的用户id）
    private LocalDateTime modifyDate; //最新更新时间

    public AppCategory(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }
}
