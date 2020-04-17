package fr.crosart.escalade.model.beans;

import lombok.Getter;
import lombok.Setter;

public class User {

    @Getter @Setter private Integer id;
    @Getter @Setter private String login;
    @Getter @Setter private String password;
    @Getter @Setter private String nickname;
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private String mail;
    @Getter @Setter private String telephone;
    @Getter @Setter private boolean member;

    public User() {
    }

}