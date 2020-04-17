package fr.crosart.escalade.model.beans;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class Comment {

    @Getter @Setter private Integer id;
    @Getter @Setter private String content;
    @Getter @Setter private LocalDate date;
    @Getter @Setter private Integer siteId;
    @Getter @Setter private Integer userId;
    @Getter @Setter private String userNickname;
    @Getter @Setter private String parsedDate;

    public Comment() {
    }

}