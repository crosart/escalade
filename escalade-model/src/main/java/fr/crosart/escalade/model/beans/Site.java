package fr.crosart.escalade.model.beans;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class Site {

    @Getter @Setter private Integer id;
    @Getter @Setter private String name;
    @Getter @Setter private String country;
    @Getter @Setter private String department;
    @Getter @Setter private String latitude;
    @Getter @Setter private String longitude;
    @Getter @Setter private String height;
    @Getter @Setter private String tracks;
    @Getter @Setter private String cotationMin;
    @Getter @Setter private String cotationMax;
    @Getter @Setter private String description;
    @Getter @Setter private boolean official;
    @Getter @Setter private LocalDate creationDate;
    @Getter @Setter private String parsedCreationDate;

    public Site() {
    }

}