package fr.crosart.escalade.business.contract.managers;

import fr.crosart.escalade.model.beans.User;
import fr.crosart.escalade.model.exceptions.FunctionalException;
import fr.crosart.escalade.model.exceptions.NotFoundException;
import fr.crosart.escalade.model.exceptions.TechnicalException;

import java.util.List;

public interface UserManager {

    /**
     * Renvoie l'{@link User} correspondant au couple login / mot de passe
     *
     * @param pLogin le login de l'Utilisateur
     * @return Le {@link User}
     * @throws NotFoundException Si l'Utilisateur n'est pas trouvé
     */
    User logUser(String pLogin) throws NotFoundException;

    User getUserDetail(Integer pId) throws NotFoundException;

    void createUser(User pUser);


//    void insertUser(User pUser) throws FunctionalException, TechnicalException;

}
