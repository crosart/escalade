package fr.crosart.escalade.consumer.contract.dao;

import fr.crosart.escalade.model.beans.User;

public interface UserDao {
    User getUser(Integer pId);
}
