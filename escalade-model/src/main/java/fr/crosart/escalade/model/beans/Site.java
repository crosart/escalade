package fr.crosart.escalade.model.beans;

import java.time.LocalDate;

public class Site {

    // ===== Attributs

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
    private boolean isOfficial;
    private LocalDate creationDate;

    // ===== Constructeurs

    /**
     * Constructeur global {@link Site}
     * @param id SQL : siteid - ID du {@link Site}
     * @param name SQL : sitename - Nom du {@link Site}
     * @param country SQL : sitecountry - Pays du {@link Site}
     * @param department SQL : sitedepartment - Département du {@link Site}
     * @param latitude SQL : sitelatitude - Latitude du {@link Site}
     * @param longitude SQL : sitelongitude - Longitude du {@link Site}
     * @param height SQL : siteheight - Hauteur du {@link Site}
     * @param tracks SQL : sitetracks - Nombre de voies du {@link Site}
     * @param cotationMin SQL : sitecotationmin - Cotation minimum du {@link Site}
     * @param cotationMax SQL : sitecotationmax - Cotation maximum du {@link Site}
     * @param description SQL : sitedescription - Description du {@link Site}
     * @param isOfficial SQL : siteisofficial - {@link Site} officiel de l'association
     * @param creationDate SQL : sitecreationdate - Date de création du {@link Site}
     */

    public Site(Integer id, String name, String country, String department, String latitude, String longitude, String height, String tracks, String cotationMin, String cotationMax, String description, boolean isOfficial, LocalDate creationDate) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.department = department;
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
        this.tracks = tracks;
        this.cotationMin = cotationMin;
        this.cotationMax = cotationMax;
        this.description = description;
        this.isOfficial = isOfficial;
        this.creationDate = creationDate;
    }

    /** Constructeur simple {@link Site}
     * @param id ID du {@link Site}
     */

    public Site(Integer id) {
        this.id = id;
    }

    public Site() {

    }

    // ===== Getters & Setters

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

    public boolean isOfficial() {
        return isOfficial;
    }
    public void setOfficial(boolean official) {
        isOfficial = official;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

}