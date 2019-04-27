package cn.appsys.pojo;

import java.time.LocalDateTime;

/**
 * @author XRZ
 * @date 2019\3\3 0003
 * @Description :
 */
public class DataDictionary {

    private Integer id;
    private String typeCode; //类型编码
    private String typeName; //类型名称
    private Integer valueId; //类型值ID
    private String valueName; //类型值Name
    private Integer createdBy; //创建者（来源于backend_user用户表的用户id）
    private LocalDateTime creationDate; //创建时间
    private Integer modifyBy; //更新者（来源于backend_user用户表的用户id）
    private LocalDateTime modifyDate; //最新更新时间

    public DataDictionary(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
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
