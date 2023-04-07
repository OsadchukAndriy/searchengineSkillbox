package searchengine.services;

import org.springframework.stereotype.Service;
import searchengine.model.Site;

import java.util.List;

@Service
public class SiteServiceImpl implements SiteService {
    @Override
    public Site saveSite(Site site) {
        return null;
    }

    @Override
    public Site getSiteById(Long id) {
        return null;
    }

    @Override
    public List<Site> getAllSites() {
        return null;
    }

    @Override
    public boolean startIndexing() {
        return false;
    }
}
