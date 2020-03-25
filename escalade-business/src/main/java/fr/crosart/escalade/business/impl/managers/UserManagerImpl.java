package fr.crosart.escalade.business.impl.managers;

import fr.crosart.escalade.business.contract.managers.UserManager;
import fr.crosart.escalade.consumer.contract.dao.UserDao;
import fr.crosart.escalade.model.beans.User;
import fr.crosart.escalade.model.exceptions.NotFoundException;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;




@Named
public class UserManagerImpl extends AbstractManager implements UserManager {

    @Inject
    private UserDao userDao;

    @Override
    public User getUserDetail(Integer pId) throws NotFoundException {
        return userDao.getUser(pId);
    }

    @Override
    public User logUser(String pMail) throws NotFoundException {

        return userDao.logUser(pMail);
       // throw new NotFoundException("Aucun utilisateur ne correspond au couple login/password saisi");
    }

    @Override
    public void createUser(User pUser) {
        userDao.createUser(pUser);
    }



}