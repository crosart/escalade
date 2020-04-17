package fr.crosart.escalade.model.beans;

import lombok.Getter;
import lombok.Setter;

public class Research {

    @Getter @Setter private String textSearch;
    @Getter @Setter private String country;
    @Getter @Setter private String department;
    @Getter @Setter private String cotationMin;
    @Getter @Setter private String cotationMax;

    public Research() {
    }

}