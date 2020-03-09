package fr.crosart.escalade.model.beans;

import java.time.LocalDate;

public class Comment {

    // Attributes
    private Integer id;
    private String content;
    private Integer siteId;
    private Integer userId;
    private LocalDate creationDate;

    // Constructeurs
    public Comment() {
    }

    /**
     * Constructeur Comment
     * @param pId
     */
    public Comment(Integer pId) {
        id = pId;
    }

    // Getters & Setters
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

}