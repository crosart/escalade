<p align="center">
<img src="https://upload.wikimedia.org/wikipedia/fr/0/0d/Logo_OpenClassrooms.png" alt="OC logo">
</p>

### Projet OpenClassrooms - Parcours Développeur d'application Java
# LES AMIS DE L'ESCALADE


##### Objectif : créer un site communautaire autour de l'escalade.

<hr>

## CONTEXTE
#### Fonctionnalités :
- Un utilisateur doit  pouvoir consulter les informations des sites d'escalade (secteurs, voies, longueurs, etc.).
- Un utilisateur doit pouvoir faire une recherche à l'aide de plusieurs critères pour trouver un site de grimpe et consulter le résultat de cette recherche. Les critères peuvent être un lieu, la cotation, le nombre de secteurs, etc.
- Un utilisateur doit pouvoir s'inscrire gratutiement sur le site.
- Un utilisateur connecté doit pouvoir partager des informations sur un site d'escalade (secteur, voies, longueurs, etc.).
- Un utilisateur connecté doit pouvoir laisser des commentaires sur les pages des sites d'escalade.
- un membre de l'association doit pouvoir taguer un site d'escalade enregistré sur la plateforme comme "Officiel Les Amis de l'Escalade".
- Un membre de l'association doit pouvoir modifier et supprimer un commentaire.
- Un utilisateur connecté doit pouvoir enregistrer dans son espace personnel les topos qu'il possède et préciser si ces derniers sont disponibles pour être prêtés ou non. Un topo est défini par un nom, une description, un lieu, et une date de parution.
- Un utilisateur connecté doit pouvoir consulter la liste des topos disponibles par d'autres utilisateurs et faire une demande de réservation. La réservation n'inclut pas les notions de date de début et date de fin.
- Un utilisateur connecté doit pouvoir accepter une demande de réservation. Si une réservation est acceptée, automatiquement le tropo devient indisponible. L'utilisateur connecté pourra ensuite de nouveau changer le statut du topo en "disponible". La plateforme se contente de mettre en contact les deux parties pour le prêt d'un topo (par échange de coordonnées).

#### Contraintes fonctionnelles :
- Le vocabulaire de l'escalade doit être utilisé : site, spot, voie, longueur, grimpeur, point ou spit, cotation, topo.
- Le site doit être *responsive*.
- Le site doit être sécurisé.

<hr>

## DEPLOIEMENT
- La source du *projet* est hérbergée sur ***GitHub*** à l'adresse : *https://github.com/crosart/escalade*
- L'application est accessible pour test à l'adresse : *https://oc.arthur.escalade.engelaere-antoine.me/*
- Le *projet* est géré par ***Apache Maven***.
- L'*application* se builde par Maven au format ***.war***.
- Les *frameworks* utilisés sont :
  - ***Spring*** / ***Spring JDBC***
  - ***Apache Struts 2***
  - ***Bootstrap 4***
- La *base de données* est déployée sur un serveur ***PostgreSQL***.
- L'*application* est déployée sur un serveur ***Apache Tomcat v9***

## RESSOURCES
- Le *script SQL* nécessaire pour créer la base de données sur le serveur **PostgreSQL** est située : "*/DEPLOYMENT RESOURCES/PostgreSQL_DB_CREATE_SCRIPT*.***sql***"
- Les données à insérer dans la base se situent :
    - "*/DEPLOYMENT RESOURCES/escalade_escalade_comment*.***csv***"
    - "*/DEPLOYMENT RESOURCES/escalade_escalade_countries*.***csv***"
    - "*/DEPLOYMENT RESOURCES/escalade_escalade_departments*.***csv***"
    - "*/DEPLOYMENT RESOURCES/escalade_escalade_registereduser*.***csv***"
    - "*/DEPLOYMENT RESOURCES/escalade_escalade_site*.***csv***"
    - "*/DEPLOYMENT RESOURCES/escalade_escalade_topo*.***csv***"
- Le jeu de données contient :
    - Une liste de topos, de sites, et de commentaires afin de visualiser les fonctionnalités et l'articulation du "*site/application*".
    - La liste des pays du monde ainsi que des départements français pour une gestion simplifiée et claire des lieux.
    - Une liste d'utilisateurs créés au préalable :
        - Un utilisateur venant de s'enregistrer (aucun droit particulier) :
            - Mail : *userpasstest@outlook.fr*
            - Mot de passe : *pass*
        - Un utilisateur avec les droits "Membre de l'association" :
            - Mail : *norsegod@gmail.com*
            - Mot de passe : *asgard*