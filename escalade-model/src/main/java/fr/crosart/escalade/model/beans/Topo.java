package fr.crosart.escalade.model.beans;

import java.time.LocalDate;

public class Topo {

    //Attributes
    private Integer id;
    private Integer siteId;
    private Integer userId;
    private LocalDate publishingDate;
    private boolean pending;
    private boolean reserved;
    private Integer reservedUserId;
    private String siteName;
    private String siteDepartment;
    private String reservedUserName;
    private String reservedUserTelephone;
    private String reservedUserMail;

    //Constructor
    public Topo() {
    }

    //Getters & Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSiteId() {
        return siteId;
    }
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }
    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public boolean isPending() {
        return pending;
    }
    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public boolean isReserved() {
        return reserved;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public Integer getReservedUserId() {
        return reservedUserId;
    }
    public void setReservedUserId(Integer reservedUserId) {
        this.reservedUserId = reservedUserId;
    }

    public String getSiteName() {
        return siteName;
    }
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteDepartment() {
        return siteDepartment;
    }
    public void setSiteDepartment(String siteDepartment) {
        this.siteDepartment = siteDepartment;
    }

    public String getReservedUserName() {
        return reservedUserName;
    }
    public void setReservedUserName(String reservedUserName) {
        this.reservedUserName = reservedUserName;
    }

    public String getReservedUserTelephone() {
        return reservedUserTelephone;
    }
    public void setReservedUserTelephone(String reservedUserTelephone) {
        this.reservedUserTelephone = reservedUserTelephone;
    }

    public String getReservedUserMail() {
        return reservedUserMail;
    }
    public void setReservedUserMail(String reservedUserMail) {
        this.reservedUserMail = reservedUserMail;
    }

}
