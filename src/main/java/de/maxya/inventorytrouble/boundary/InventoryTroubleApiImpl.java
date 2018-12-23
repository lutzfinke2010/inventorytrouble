package de.maxya.inventorytrouble.boundary;


import de.maxya.inventorytrouble.boundary.model.*;
import de.maxya.inventorytrouble.boundary.rest.InventoryTroubleApi;
import de.maxya.inventorytrouble.control.ArtikelService;
import de.maxya.inventorytrouble.control.RBLGameService;
import de.maxya.inventorytrouble.control.rblparser.RBLPageParser;
import de.maxya.inventorytrouble.control.schedule.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InventoryTroubleApiImpl implements InventoryTroubleApi {

    private static final Logger LOGGER = LogManager.getLogger(InventoryTroubleApiImpl.class);

    @Override
    public List<Artikel> getArtikels() {
        Artikel a = new Artikel();
        a.setName("Apfell");
        a.setTenantId("guest");
        a.setId(2l);
        List<Artikel> art = this.artikelService.getArtikels("hallo");
        art.add(a);
        return art;
    }

    @Autowired
    private ArtikelService artikelService;

    @Override
    public ResponseEntity<Void> createArtikel(@PathVariable String tenantId, @RequestBody Artikel artikel) {

        final Artikel createdArtikel = this.artikelService.createArtikel(tenantId, artikel);

        final ResponseEntity<Void> createArtikelLink = ControllerLinkBuilder.methodOn(InventoryTroubleApiImpl.class)
                .createArtikel(tenantId, artikel);

        final URI location = ControllerLinkBuilder.linkTo(createArtikelLink).slash(createdArtikel.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @Autowired
    RBLPageParser parser;

    @Autowired
    RBLGameService service;

    @Override
    public List<RBLGames> getRBLGames()
    {
        return service.getRBLGames("Scheduler");
    }

    @Override
    public List<RBLGames> getRBLGamesMitBBlockPlaetzen() {
        return service.getRBLGamesMitBBlockPlaetzen("Scheduler");
    }

    @Override
    public List<RBLSitzplatz> getRBLSitzplaetze() {
        return service.getSitzplaetze("Scheduler");
    }

    @Autowired
    RblParserSchedule schedule;

    @Override
    public String stopParser() {
        LOGGER.info("Parser STOPPED");
        schedule.stop();
        return "stopped";
    }

    @Override
    public String startParser() {
        LOGGER.info("Parser STARTED");
        schedule.start();
        return "started";
    }

    @Override
    public boolean getParserStatus() {
        return schedule.getStatus();
    }

    @Override
    public List<RBLSitzplatzAnzahlVerlauf> getRBLGamesVerlauf() {
        return service.getRBLGamesVerlauf("Scheduler");
    }

    @Override
    public List<RBLGameSearchOption> getSearchOptions() {
        schedule.logSearchOptions();
        return schedule.getSearchOptions();
    }

    @Override
    public void setSearchOptions(@RequestBody RBLGameSearchOptionToSend searchOption) {
        schedule.changeSearchOptions(searchOption);
    }

    @Override
    public List<RBLRuleToSend> getRules() {
        List<RBLRuleToSend> rules = new ArrayList<>();
        RBLRuleToSend a = new RBLRuleToSend();
        a.setId(new RBLRuleSektorA().getId());
        a.setName(new RBLRuleSektorA().getName());

        RBLRuleToSend b = new RBLRuleToSend();
        b.setId(new RBLRuleSektorB().getId());
        b.setName(new RBLRuleSektorB().getName());

        RBLRuleToSend c = new RBLRuleToSend();
        c.setId(new RBLRuleSektorC().getId());
        c.setName(new RBLRuleSektorC().getName());

        RBLRuleToSend d = new RBLRuleToSend();
        d.setId(new RBLRuleSektorD().getId());
        d.setName(new RBLRuleSektorD().getName());

        rules.add(a);
        rules.add(b);
        rules.add(c);
        rules.add(d);
        return rules;
    }

    @Override
    public List<String> getGameNames() {
        return schedule.getListOfGameNames();
    }

    @Override
    public String webServiceTest(@PathVariable String tenantId) {
        return "Test OK for TenantId " + tenantId;
    }
}
