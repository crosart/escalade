package fr.crosart.escalade.business.impl.managers;

import fr.crosart.escalade.business.contract.managers.SiteManager;
import fr.crosart.escalade.model.beans.Site;
import fr.crosart.escalade.model.exceptions.NotFoundException;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class SiteManagerImpl extends AbstractManager implements SiteManager {

    @Override
    public Site getSite(Integer pId) throws NotFoundException {
        if (pId < 0) {
            throw new NotFoundException("Site non trouvé : ID = " + pId);
        }
        Site vSite = newSite(pId);
        return vSite;
    }

    @Override
    public List<Site> getListSite() {
        List<Site> vList = new ArrayList<>();
        for (int vI = 0; vI < 4; vI++) {
            Site vSite = newSite(vI);
            vList.add(vSite);
        }
        return vList;
    }

    private Site newSite(Integer pId) {
        String[] vNames = { "Ablon", "Ailefroide", "Annot", "Antalia" };
        String[] vCountries = { "France", "France", "France", "Turquie" };
        String[] vDepartments = { "Haute-Savoie", "Hautes-Alpes", "Alpes-de-Haute-Provence", "Turquie"};
        String[] vHeights = { "80m", "400m", "25m", "NC" };
        String[] vTracks = { "400", "500", "400", "NC" };
        String[] vCotationMin = { "4b", "3a", "4c", "3a"};
        String[] vCotationMax = { "8b", "8a", "8c+", "8c" };
        String[] vDescription = {
                "Ablon, c’est la falaise d’alpages, nichée à l’écart, dans un recoin sauvage et préservé en plein cœur du massif des Bornes.",
                "Situé presque au fond de la vallée de la Vallouise, au Nord de L’Argentière la Bessée, existe-t-il meilleur endroit pour grimper en été ?",
                "À mi-chemin entre Dignes les Bains et Nice, un peu perché dans l’arrière-pays montagnard, Annot est l’un des plus beaux spots de grimpe du Sud.",
                "Geyikbayiri ou Akyalar, tels sont les noms des falaises du coin."
        };
        Site vSite = new Site(pId);
        vSite.setName(vNames[Math.abs(pId) % vNames.length]);
        vSite.setCountry(vCountries[Math.abs(pId) % vCountries.length]);
        vSite.setDepartment(vDepartments[Math.abs(pId) % vDepartments.length]);
        vSite.setLatitude("Latitude N-S");
        vSite.setLongitude("Longitude E-O");
        vSite.setHeight(vHeights[Math.abs(pId) % vHeights.length]);
        vSite.setTracks(vTracks[Math.abs(pId) % vTracks.length]);
        vSite.setCotationMin(vCotationMin[Math.abs(pId) % vCotationMin.length]);
        vSite.setCotationMax(vCotationMax[Math.abs(pId) % vCotationMax.length]);
        vSite.setDescription(vDescription[Math.abs(pId) % vDescription.length]);
        vSite.setOfficial(true);

        return vSite;
    }

}
