package de.maxya.inventorytrouble.boundary.rest;

import de.maxya.inventorytrouble.boundary.model.*;
import de.maxya.inventorytrouble.control.schedule.RblGameSearchOption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping(value="/api/v1", method = RequestMethod.GET, produces={"application/json; charset=utf-8","text/plain; charset=utf-8"})
public interface InventoryTroubleApi {
    @RequestMapping(value="/tenants/{tenantId}/items", method = RequestMethod.GET)
    List<Artikel> getArtikels();

    @RequestMapping(value="/tenants/{tenantId}/item", method = RequestMethod.POST, consumes={"application/json; charset=utf-8"})
    ResponseEntity<Void> createArtikel(@PathVariable String tenantId, @RequestBody Artikel artikel);

    @RequestMapping(value="/tenants/{tenantId}/rblgames", method = RequestMethod.GET)
    List<RBLGames> getRBLGames();

    @RequestMapping(value="/tenants/{tenantId}/rblgames/bblock", method = RequestMethod.GET)
    List<RBLGames> getRBLGamesMitBBlockPlaetzen();

    @RequestMapping(value="/tenants/{tenantId}/rblsitzplaetze", method = RequestMethod.GET)
    List<RBLSitzplatz> getRBLSitzplaetze();

    @RequestMapping(value="/tenants/{tenantId}/rblschedule/stop", method = RequestMethod.GET, produces={"application/json;"})
    String stopParser();

    @RequestMapping(value="/tenants/{tenantId}/rblschedule/start", method = RequestMethod.GET, produces={"application/json;"})
    String startParser();

    @RequestMapping(value="/tenants/{tenantId}/rblschedule", method = RequestMethod.GET, produces={"application/json;"})
    boolean getParserStatus();

    @RequestMapping(value="/tenants/{tenantId}/rblgamesverlauf", method = RequestMethod.GET)
    List<RBLSitzplatzAnzahlVerlauf> getRBLGamesVerlauf();

    @RequestMapping(value="/tenants/{tenantId}/searchoptions", method = RequestMethod.GET)
    List<RblGameSearchOption> getSearchOptions();

    @RequestMapping(value="/tenants/{tenantId}/searchoptionschange", method = RequestMethod.PUT, consumes={"application/json; charset=utf-8"})
    void setSearchOptions(@RequestBody RBLGameSearchOptionToSend searchOption);

    @RequestMapping(value="/tenants/{tenantId}/rule", method = RequestMethod.GET)
    List<RBLRuleToSend> getRules();

    @RequestMapping(value="/tenants/{tenantId}/gamenames", method = RequestMethod.GET)
    List<String> getGameNames();

    @RequestMapping(value="/tenants/{tenantId}/webservicetest", method = RequestMethod.GET)
    String webServiceTest(@PathVariable String tenantId);

    @RequestMapping(value="/tenants/{tenantId}/gametosearch", method = RequestMethod.POST, consumes={"application/json; charset=utf-8"})
    ResponseEntity<Void> addOrRemoveGameToSearch(@PathVariable String tenantId, @RequestBody RBLGameToSearch gameToSearch);
}
