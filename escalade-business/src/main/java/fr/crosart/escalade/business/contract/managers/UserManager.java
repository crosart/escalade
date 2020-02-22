package fr.crosart.escalade.business.contract.managers;

import fr.crosart.escalade.model.beans.User;
import fr.crosart.escalade.model.exceptions.FunctionalException;
import fr.crosart.escalade.model.exceptions.NotFoundException;
import fr.crosart.escalade.model.exceptions.TechnicalException;

import java.util.List;

public interface UserManager {

    /**
     * Renvoie la liste des {@link User}
     * @return List
     */
    List<User> getListUser();

    /**
     * Renvoie l'utilisateur demandé
     * @param pId (ID de l'utilisateur)
     * @return {@link User}
     * @throws NotFoundException Si le site n'existe pas
     */
    User getUser(Integer pId) throws NotFoundException;

    /**
     * Renvoie l'{@link User} correspondant au couple login / mot de passe
     *
     * @param pLogin le login de l'Utilisateur
     * @param pPassword le mot de passe de l'Utilisateur
     * @return Le {@link User}
     * @throws NotFoundException Si l'Utilisateur n'est pas trouvé
     */
    User getUser(String pLogin, String pPassword) throws NotFoundException;


//    void insertUser(User pUser) throws FunctionalException, TechnicalException;

}
