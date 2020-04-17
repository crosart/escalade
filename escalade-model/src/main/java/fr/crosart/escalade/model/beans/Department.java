package fr.crosart.escalade.model.beans;

import lombok.Getter;
import lombok.Setter;

public class Department {

    @Getter @Setter private Integer id;
    @Getter @Setter private String code;
    @Getter @Setter private String name;

    public Department() {
    }

}
