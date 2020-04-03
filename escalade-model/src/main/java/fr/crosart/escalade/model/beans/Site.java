package fr.crosart.escalade.model.beans;

import java.time.LocalDate;

public class Site {

    //Attributes
    private Integer id;
    private String name;
    private String country;
    private String department;
    private String latitude;
    private String longitude;
    private String height;
    private String tracks;
    private String cotationMin;
    private String cotationMax;
    private String description;
    private boolean official;
    private LocalDate creationDate;

    //Constructor
    public Site() {
    }

    //Getters & Setters
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

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getHeight() {
        return height;
    }
    public void setHeight(String height) {
        this.height = height;
    }

    public String getTracks() {
        return tracks;
    }
    public void setTracks(String tracks) {
        this.tracks = tracks;
    }

    public String getCotationMin() {
        return cotationMin;
    }
    public void setCotationMin(String cotationMin) {
        this.cotationMin = cotationMin;
    }

    public String getCotationMax() {
        return cotationMax;
    }
    public void setCotationMax(String cotationMax) {
        this.cotationMax = cotationMax;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOfficial() {
        return official;
    }
    public void setOfficial(boolean official) {
        this.official = official;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

}