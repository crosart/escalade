package fr.crosart.escalade.consumer.impl.dao;

import fr.crosart.escalade.consumer.contract.dao.UserDao;
import fr.crosart.escalade.model.beans.User;

import javax.inject.Named;

@Named
public class UserDaoImpl extends AbstractDaoImpl implements UserDao {
    @Override
    public User getUser(Integer pId) {
        return null;
    }
}
