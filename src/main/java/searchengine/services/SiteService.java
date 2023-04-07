package searchengine.services;

import searchengine.model.Site;

import java.util.List;

public interface SiteService {
    Site saveSite(Site site);

    Site getSiteById(Long id);

    List<Site> getAllSites();

    boolean startIndexing();

}
