package fr.crosart.escalade.model.beans;

public class Country {

    //Attributes
    private Integer id;
    private String code;
    private String name;

    //Contructor
    public Country() {
    }

    //Getters & Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
