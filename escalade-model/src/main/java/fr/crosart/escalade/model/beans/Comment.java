package fr.crosart.escalade.model.beans;

import java.time.LocalDate;

public class Comment {

    //Attributes
    private Integer id;
    private String content;
    private LocalDate date;
    private Integer siteId;
    private Integer userId;
    private String userNickname;
    private String parsedDate;

    //Constructor
    public Comment() {
    }

    //Getters & Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
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

    public String getUserNickname() {
        return userNickname;
    }
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getParsedDate() {
        return parsedDate;
    }
    public void setParsedDate(String parsedDate) {
        this.parsedDate = parsedDate;
    }
}