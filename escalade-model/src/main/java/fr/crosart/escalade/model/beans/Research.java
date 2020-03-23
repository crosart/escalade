package fr.crosart.escalade.model.beans;

public class Research {

    private String textSearch;
    private String country;
    private String department;
    private String cotationMin;
    private String cotationMax;

    public Research() {
    }
    public Research(String textSearch, String country, String department, String cotationMin, String cotationMax) {
        this.textSearch = textSearch;
        this.country = country;
        this.department = department;
        this.cotationMin = cotationMin;
        this.cotationMax = cotationMax;
    }

    public String getTextSearch() {
        return textSearch;
    }
    public void setTextSearch(String textSearch) {
        this.textSearch = textSearch;
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
}
