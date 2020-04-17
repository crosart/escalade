package fr.crosart.escalade.model.beans;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class Topo {

    @Getter @Setter private Integer id;
    @Getter @Setter private Integer siteId;
    @Getter @Setter private Integer userId;
    @Getter @Setter private LocalDate publishingDate;
    @Getter @Setter private Integer reservedUserId;
    @Getter @Setter private String siteName;
    @Getter @Setter private String siteDepartment;
    @Getter @Setter private String reservedUserName;
    @Getter @Setter private String reservedUserTelephone;
    @Getter @Setter private String reservedUserMail;
    @Getter @Setter private String parsedPublishingDate;
    @Getter @Setter private boolean pending;
    @Getter @Setter private boolean reserved;

    public Topo() {
    }

}
