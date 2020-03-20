package fr.crosart.escalade.consumer.contract.dao;

import fr.crosart.escalade.model.beans.User;
import fr.crosart.escalade.model.exceptions.NotFoundException;

public interface UserDao {

    User getUser(Integer pId) throws NotFoundException;

    User logUser(String pLogin) throws NotFoundException;

    void createUser(User pUser);

}
