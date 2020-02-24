package fr.crosart.escalade.business.impl.managers;

import fr.crosart.escalade.business.contract.managers.UserManager;
import fr.crosart.escalade.model.beans.User;
import fr.crosart.escalade.model.exceptions.NotFoundException;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class UserManagerImpl extends AbstractManager implements UserManager {

    @Override
    public User getUser(Integer pId) throws NotFoundException {
        if (pId < 0) {
            throw new NotFoundException("Utilisateur non trouvé : ID = " + pId);
        }
        User vUser = newUser(pId);
        return vUser;
    }

    @Override
    public User getUser(String pLogin, String pPassword) throws NotFoundException {
        if (StringUtils.equals(pLogin, "crosart") && StringUtils.equals(pPassword, "crosart")) {
            return newUser(0);
        }
        throw new NotFoundException("Aucun utilisateur ne correspond au couple login/password saisi");
    }

    @Override
    public List<User> getListUser() {
        List<User> vList = new ArrayList<>();
        for (int vI = 0; vI < 9; vI++) {
            User vUser = newUser(vI);
            vList.add(vUser);
        }
        return vList;
    }

    /**
     * Renvoie l'{@link User} demandé
     * @param pId -
     * @return User
     */
    private User newUser(Integer pId) {
        String[] vFirstName = {
            "Pierre", "Paul", "Jacques"
        };
        User vUser = new User(pId);
        vUser.setFirstName(vFirstName[Math.abs(pId) % vFirstName.length]);
        vUser.setLastName("Dupont");
        return vUser;
    }

}