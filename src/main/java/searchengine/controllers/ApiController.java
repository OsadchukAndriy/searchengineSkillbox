package searchengine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import searchengine.dto.statistics.StatisticsResponse;
import searchengine.services.SiteService;
import searchengine.services.StatisticsService;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final StatisticsService statisticsService;
    private final SiteService siteService;

    @Autowired
    public ApiController(StatisticsService statisticsService, SiteService siteService) {
        this.statisticsService = statisticsService;
        this.siteService = siteService;
    }



    @GetMapping("/startIndexing")
    public ResponseEntity<Map<String, Object>> startIndexing() {
        boolean success = siteService.startIndexing();
        if (success) {
            return ResponseEntity.ok(Collections.singletonMap("result", true));
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("result", false);
            response.put("error", "Индексация уже запущена");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/statistics")
    public ResponseEntity<StatisticsResponse> statistics() {
        return ResponseEntity.ok(statisticsService.getStatistics());
    }
}
