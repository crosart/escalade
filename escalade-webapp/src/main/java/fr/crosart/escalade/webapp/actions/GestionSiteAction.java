package fr.crosart.escalade.webapp.actions;

import fr.crosart.escalade.business.contract.ManagerFactory;
import fr.crosart.escalade.model.beans.*;
import fr.crosart.escalade.model.exceptions.NotFoundException;
import org.apache.commons.lang3.StringUtils;
import com.opensymphony.xwork2.ActionSupport;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named("gestionSiteAction")
public class GestionSiteAction extends ActionSupport {

    @Inject
    private ManagerFactory managerFactory;

    @Getter @Setter private Site site = new Site();
    @Getter @Setter private Research research = new Research();
    @Getter @Setter private Integer siteId;

    @Getter private String[] cotations = new String[]{"1","2","3","4","5a","5b","5c","6a","6a+","6b","6b+","6c","6c+","7a","7a+","7b","7b+","7c","7c+","8a","8a+","8b","8b+","8c","8c+","9a","9a+","9b","9b+","9c","9c+"};
    @Getter private String[] reversedcotations = new String[]{"9c+","9c","9b+","9b","9a+","9a","8c+","8c","8b+","8b","8a+","8a","7c+","7c","7b+","7b","7a+","7a","6c+","6c","6b+","6b","6a+","6a","5c","5b","5a","4","3","2","1"};
    @Getter private String[] departments;
    @Getter private String[] countries;
    @Getter private List<Site> listSite;
    @Getter private List<Comment> listComment;
    @Getter private List<Topo> listTopo;

    @Setter private String country;
    @Setter private String department;
    @Setter private String cotationMin;
    @Setter private String cotationMax;
    @Setter private String search;
    @Setter private Integer id;
    @Setter private String name;
    @Setter private String latitude;
    @Setter private String longitude;
    @Setter private String height;
    @Setter private String tracks;
    @Setter private String description;

    /**
     * Action > Recherche les {@link Site} selon différents critères
     * @return INPUT | SUCCESS
     */
    public String doSearch() {
        List<Site> listDepartment = managerFactory.getSiteManager().getSiteDepartments();
        departments = new String[listDepartment.size()+1];
        departments[0] = "Département";
        for (int i = 0; i < listDepartment.size(); i++) {
            departments[i+1] = listDepartment.get(i).getDepartment();
        }

        List<Site> listCountry = managerFactory.getSiteManager().getSiteCountries();
        countries = new String[listCountry.size()+1];
        countries[0] = "Pays";
        for (int i = 0; i < listCountry.size(); i++) {
            countries[i+1] = listCountry.get(i).getCountry();
        }

        String vResult = ActionSupport.INPUT;
        if (!StringUtils.isEmpty(search) || !StringUtils.isEmpty(country) || !StringUtils.isEmpty(department) || !StringUtils.isEmpty(cotationMin) || !StringUtils.isEmpty(cotationMax)) {
            try {
                research.setTextSearch(search);
                research.setCountry(country);
                research.setDepartment(department);
                research.setCotationMin(cotationMin);
                research.setCotationMax(cotationMax);
                listSite = managerFactory.getSiteManager().getListSite(research);

                vResult = ActionSupport.SUCCESS;
            } catch (Exception vEx) {
                vEx.printStackTrace();
                String exception = vEx.getMessage();
                this.addActionError("Erreur lors de la recherche");
            }
            return vResult;
        }
        return vResult;
    }

    /**
     * Action > Liste les derniers {@link Site} ajoutés
     * @return SUCCESS
     */
    public String doList() {
        listSite = managerFactory.getSiteManager().getListSite();
        return ActionSupport.SUCCESS;
    }

    /**
     * Action > Affiche le détail du {@link Site} déterminé
     * @return ERROR | SUCCESS
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError(getText("error.site.missing.id"));
        } else {
            try {
                site = managerFactory.getSiteManager().getDetailSite(id);
                listComment = managerFactory.getCommentManager().getCommentsList(id);
                listTopo = managerFactory.getTopoManager().getListTopoSite(id);

                siteId = site.getId();
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.site.notfound", Collections.singletonList(id)));
            }
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    /**
     * Action > Crée un nouveau {@link Site}
     * @return INPUT | SUCCESS
     */
    public String doCreate() {
        LocalDate vDate = LocalDate.now();

        List<Department> listDepartment = managerFactory.getDepartmentManager().getListDepartments();
        departments = new String[listDepartment.size()+1];
        departments[0] = "Département";
        for (int i = 0; i < listDepartment.size(); i++) {
            departments[i+1] = listDepartment.get(i).getName();
        }

        List<Country> listCountry = managerFactory.getCountryManager().getListCountries();
        countries = new String[listCountry.size()+1];
        countries[0] = "Pays";
        for (int i = 0; i < listCountry.size(); i++) {
            countries[i+1] = listCountry.get(i).getName();
        }

        String vResult = ActionSupport.INPUT;
        if (!StringUtils.isEmpty(name)) {
            try {
                site.setName(name);
                site.setCountry(country);
                site.setDepartment(department);
                site.setLatitude(latitude);
                site.setLongitude(longitude);
                site.setHeight(height);
                site.setTracks(tracks);
                site.setCotationMin(cotationMin);
                site.setCotationMax(cotationMax);
                site.setDescription(description);
                site.setOfficial(false);
                site.setCreationDate(vDate);

                managerFactory.getSiteManager().insertSite(site);

                vResult = ActionSupport.SUCCESS;
            } catch (Exception vEx) {
                vEx.printStackTrace();
                this.addActionError("Erreur lors de l'ajout !");
            }
            return vResult;
        }
        return vResult;
    }

    /**
     * Action > Modifie le statut d'un {@link Site} déterminé en "Officiel"
     * @return SUCCESS
     */
    public String doSetOfficial() {
        managerFactory.getSiteManager().setSiteOfficial(id);

        return ActionSupport.SUCCESS;
    }
}