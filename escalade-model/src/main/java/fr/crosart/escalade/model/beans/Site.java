package fr.crosart.escalade.model.beans;

public class Site {

    // Attributs
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


    // Constructeurs
    public Site() {
    }

    /** Constructeur Site
     * @param pId
     */
    public Site(Integer pId) {
        id = pId;
    }

    // Getters & Setters
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

}