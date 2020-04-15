package fr.crosart.escalade.business.contract.managers;

import fr.crosart.escalade.model.beans.User;
import fr.crosart.escalade.model.exceptions.NotFoundException;

public interface UserManager {

    User logUser(String pMail) throws NotFoundException;

    User getUserDetail(Integer pId) throws NotFoundException;

    void createUser(User pUser);

}
