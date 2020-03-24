package fr.crosart.escalade.webapp.actions;

import com.opensymphony.xwork2.ActionSupport;
import fr.crosart.escalade.business.contract.ManagerFactory;
import fr.crosart.escalade.model.beans.*;
import fr.crosart.escalade.model.exceptions.NotFoundException;
import org.apache.commons.lang3.StringUtils;


import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Named("gestionSiteAction")
public class GestionSiteAction extends ActionSupport {
    // ===== Attributs
    @Inject
    private ManagerFactory managerFactory;

    @Inject
    private Site siteBean;

    @Inject
    private Research researchBean;

    // -- Entrée
    private Integer id;


    private String name;
    private String country;
    private String department;
    private String latitude;
    private String longitude;
    private String height;
    private String tracks;
    private String cotationMin;
    private String cotationMax;
    private String description;
    private boolean official;
    private LocalDate creationDate;
    private String search;


    private String[] departments;
    private String[] countries;

    private int currentUserId;
    private String[] cotations = new String[]{"1","2","3","4","5a","5b","5c","6a","6a+","6b","6b+","6c","6c+","7a","7a+","7b","7b+","7c","7c+","8a","8a+","8b","8b+","8c","8c+","9a","9a+","9b","9b+","9c","9c+"};
    private String[] reversedcotations = new String[]{"9c+","9c","9b+","9b","9a+","9a","8c+","8c","8b+","8b","8a+","8a","7c+","7c","7b+","7b","7a+","7a","6c+","6c","6b+","6b","6a+","6a","5c","5b","5a","4","3","2","1"};


    // -- Sortie
    private List<Site> listSite;
    private List<Comment> listComment;
    private Site site;
    private Comment currentComment = new Comment();
    private Topo topo;
    private User user = new User();

    // ===== Getters & Setters
    public void setId(Integer id) {
        this.id = id;
    }
    public List<Site> getListSite() {
        return listSite;
    }
    public void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }
    public Site getSite() {
        return site;
    }
    public void setSite(Site pSite) {
        site = pSite;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public void setTracks(String tracks) {
        this.tracks = tracks;
    }
    public void setCotationMin(String cotationMin) {
        this.cotationMin = cotationMin;
    }
    public void setCotationMax(String cotationMax) {
        this.cotationMax = cotationMax;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setOfficial(boolean official) {
        this.official = official;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public String[] getCotations() {
        return cotations;
    }
    public String[] getReversedcotations() {
        return reversedcotations;
    }
    public List<Comment> getListComment() {
        return listComment;
    }
    public String getSearch() {
        return search;
    }
    public void setSearch(String search) {
        this.search = search;
    }
    public Topo getTopo() {
        return topo;
    }
    public void setTopo(Topo topo) {
        this.topo = topo;
    }
    public Research getResearchBean() {
        return researchBean;
    }
    public void setResearchBean(Research researchBean) {
        this.researchBean = researchBean;
    }
    public String[] getDepartments() {
        return departments;
    }
    public String[] getCountries() {
        return countries;
    }

    public void setDepartments(String[] departments) {
        this.departments = departments;
    }

    // ===== Méthodes

    public String doQuickSearch() {
        listSite = managerFactory.getSiteManager().getListSite(search);
        return ActionSupport.SUCCESS;
    }

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
                researchBean.setTextSearch(search);
                researchBean.setCountry(country);
                researchBean.setDepartment(department);
                researchBean.setCotationMin(cotationMin);
                researchBean.setCotationMax(cotationMax);

                listSite = managerFactory.getSiteManager().getListSite(researchBean);

                vResult = ActionSupport.SUCCESS;

            } catch (Exception vEx) {
                vEx.printStackTrace();
                this.addActionError("Erreur lors de la recherche");
            }
            return vResult;
        }

        return vResult;
    }

    public String doList() {
        listSite = managerFactory.getSiteManager().getListSite();
        return ActionSupport.SUCCESS;
    }

    public String doDetail() {
        if (id == null) {
            this.addActionError(getText("error.site.missing.id"));
        } else {
            try {
                site = managerFactory.getSiteManager().getDetailSite(id);
                listComment = managerFactory.getCommentManager().getListComment(id);
                topo = managerFactory.getTopoManager().getTopo(id);

            } catch (NotFoundException pE) {
                this.addActionError(getText("error.site.notfound", Collections.singletonList(id)));
            }
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doCreate() {
        LocalDate vDate = LocalDate.now();

        String vResult = ActionSupport.INPUT;
        if (!StringUtils.isEmpty(name)) {
            try {
                siteBean.setName(name);
                siteBean.setCountry(country);
                siteBean.setDepartment(department);
                siteBean.setLatitude(latitude);
                siteBean.setLongitude(longitude);
                siteBean.setHeight(height);
                siteBean.setTracks(tracks);
                siteBean.setCotationMin(cotationMin);
                siteBean.setCotationMax(cotationMax);
                siteBean.setDescription(description);
                siteBean.setOfficial(false);
                siteBean.setCreationDate(vDate);

                managerFactory.getSiteManager().insertSite(siteBean);

                vResult = ActionSupport.SUCCESS;

            } catch (Exception vEx) {
                vEx.printStackTrace();
                this.addActionError("Erreur lors de l'ajout !");
            }

            return vResult;
        }



        return vResult;
    }

}
