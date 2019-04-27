package cn.appsys.pojo;

import java.time.LocalDateTime;

/**
 * @author XRZ
 * @date 2019\3\3 0003
 * @Description :
 */
public class AdPromotion {

    private Integer id;
    private Integer appId; // appId（来源于：app_info表的主键id）
    private String adPicPath;//广告图片存储路径
    private Integer adPV;//广告点击量
    private Integer carouselPosition;//轮播位（1-n）
    private LocalDateTime startTime;//起效时间
    private LocalDateTime endTime;//失效时间
    private Integer createdBy; //创建者（来源于backend_user用户表的用户id）
    private LocalDateTime creationDate; //创建时间
    private Integer modifyBy; //更新者（来源于backend_user用户表的用户id）
    private LocalDateTime modifyDate; //最新更新时间

    public AdPromotion(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAdPicPath() {
        return adPicPath;
    }

    public void setAdPicPath(String adPicPath) {
        this.adPicPath = adPicPath;
    }

    public Integer getAdPV() {
        return adPV;
    }

    public void setAdPV(Integer adPV) {
        this.adPV = adPV;
    }

    public Integer getCarouselPosition() {
        return carouselPosition;
    }

    public void setCarouselPosition(Integer carouselPosition) {
        this.carouselPosition = carouselPosition;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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
