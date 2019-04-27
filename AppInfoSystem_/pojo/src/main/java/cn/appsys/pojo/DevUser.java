package cn.appsys.pojo;


import java.time.LocalDateTime;

/**
 * @author XRZ
 * @date 2019\3\3 0003
 * @Description : 开发者实体类
 */
public class DevUser {

    private Integer id;
    private String devCode; //开发者帐号
    private String devName;  //开发者名称
    private String devPassword; //开发者密码
    private String devEmail; //开发者电子邮箱
    private String devInfo; //开发者简介
    private Integer createdBy; //创建者（来源于backend_user用户表的用户id）
    private LocalDateTime creationDate; //创建时间
    private Integer modifyBy; //更新者（来源于backend_user用户表的用户id）
    private LocalDateTime modifyDate; //最新更新时间

    public DevUser(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getDevPassword() {
        return devPassword;
    }

    public void setDevPassword(String devPassword) {
        this.devPassword = devPassword;
    }

    public String getDevEmail() {
        return devEmail;
    }

    public void setDevEmail(String devEmail) {
        this.devEmail = devEmail;
    }

    public String getDevInfo() {
        return devInfo;
    }

    public void setDevInfo(String devInfo) {
        this.devInfo = devInfo;
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
