package fr.crosart.escalade.model.beans;

import java.time.LocalDate;

public class Topo {

    private Integer id;
    private Integer siteId;
    private Integer userId;
    private LocalDate publishingDate;
    private boolean isReserved;
    private String siteName;
    private String siteDepartment;

    public Topo(Integer pSiteId) {
        siteId = pSiteId;
    }

    public Topo() {
    }

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
    public boolean isReserved() {
        return isReserved;
    }
    public void setReserved(boolean reserved) {
        isReserved = reserved;
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
}
