package de.maxya.inventorytrouble.control.schedule;

import de.maxya.inventorytrouble.InventorytroubleApplicationConfig;
import de.maxya.inventorytrouble.boundary.model.RBLGameToSearch;
import de.maxya.inventorytrouble.boundary.model.RBLGames;
import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import de.maxya.inventorytrouble.control.rules.RBLRuleSektorB;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = InventorytroubleApplicationConfig.class, loader = AnnotationConfigContextLoader.class)
@SpringBootTest
public class RblParserSchedule_GamesToSearchTests {


    @Test
    public void test_constructor_searchListMustBeEmpty() {
        RblParserSchedule schedule = new RblParserSchedule();
        Assert.assertEquals(schedule.getSearchOptions().size(), 0);
    }


    @Test
    public void test_addOrRemoveGameToSearchWithCorrectObject_ContainsOneSearchOption() {
        RblParserSchedule schedule = new RblParserSchedule();
        RBLGameToSearch gameToSearch = new RBLGameToSearch();
        gameToSearch.setName("RB Leipzig-Hertha BSC");
        gameToSearch.setSektor("B");
        gameToSearch.setAktiv(true);
        schedule.addOrRemoveGameToSearch(gameToSearch);
        Assert.assertEquals(schedule.getSearchOptions().size(), 1);
        schedule.getSearchOptions().stream().forEach((searchOption)->{
            Assert.assertEquals(searchOption.name, gameToSearch.getName());
            Assert.assertEquals(searchOption.getRules().size(), 1);
            searchOption.getRules().stream().forEach((rules)->{
                Assert.assertEquals(rules.getName(), "Sektor B");
            });
        });
    }

    @Test
    public void test_addOrRemoveGameToSearchWithInactiveObject_ContainsNoSearchOption() {
        RblParserSchedule schedule = new RblParserSchedule();
        RBLGameToSearch gameToSearch = new RBLGameToSearch();
        gameToSearch.setName("RB Leipzig-Hertha BSC");
        gameToSearch.setSektor("B");
        gameToSearch.setAktiv(false);
        schedule.addOrRemoveGameToSearch(gameToSearch);
        Assert.assertEquals(schedule.getSearchOptions().size(), 0);
    }

    @Test
    public void test_addOrRemoveGameToSearchRemoveAnExistingObject_ContainsNoSearchOption() {
        //Arrange
        RblParserSchedule schedule = new RblParserSchedule();
        RBLGameToSearch gameToSearch = new RBLGameToSearch();
        gameToSearch.setName("RB Leipzig-Hertha BSC");
        gameToSearch.setSektor("B");
        gameToSearch.setAktiv(true);
        schedule.addOrRemoveGameToSearch(gameToSearch);

        //Act
        RBLGameToSearch gameToRemoveSearch = new RBLGameToSearch();
        gameToRemoveSearch.setName("RB Leipzig-Hertha BSC");
        gameToRemoveSearch.setSektor("B");
        gameToRemoveSearch.setAktiv(false);
        schedule.addOrRemoveGameToSearch(gameToRemoveSearch);

        //Assert
        Assert.assertEquals(schedule.getSearchOptions().size(), 0);
    }

    @Test
    public void test_addOrRemoveGameToSearchSektorBAndSektorDForSameGame_ContainsOneSearchOptionWithTwoSektors() {
        //Arrange
        RblParserSchedule schedule = new RblParserSchedule();
        RBLGameToSearch gameToSearch = new RBLGameToSearch();
        gameToSearch.setName("RB Leipzig-Hertha BSC");
        gameToSearch.setSektor("B");
        gameToSearch.setAktiv(true);
        schedule.addOrRemoveGameToSearch(gameToSearch);

        //Act
        RBLGameToSearch gameToRemoveSearch = new RBLGameToSearch();
        gameToRemoveSearch.setName("RB Leipzig-Hertha BSC");
        gameToRemoveSearch.setSektor("D");
        gameToRemoveSearch.setAktiv(true);
        schedule.addOrRemoveGameToSearch(gameToRemoveSearch);

        //Assert
        Assert.assertEquals(1,schedule.getSearchOptions().size());
        Assert.assertEquals(2, schedule.getSearchOptions().stream().findFirst().get().getRules().size());
    }

    @Test
    public void test_addOrRemoveGameToSearchSektorBAndSektorBForSameGame_ContainsOneSearchOptionWithOnlySektorB() {
        //Arrange
        RblParserSchedule schedule = new RblParserSchedule();
        RBLGameToSearch gameToSearch = new RBLGameToSearch();
        gameToSearch.setName("RB Leipzig-Hertha BSC");
        gameToSearch.setSektor("B");
        gameToSearch.setAktiv(true);
        schedule.addOrRemoveGameToSearch(gameToSearch);

        //Act
        RBLGameToSearch gameToRemoveSearch = new RBLGameToSearch();
        gameToRemoveSearch.setName("RB Leipzig-Hertha BSC");
        gameToRemoveSearch.setSektor("B");
        gameToRemoveSearch.setAktiv(true);
        schedule.addOrRemoveGameToSearch(gameToRemoveSearch);

        //Assert
        Assert.assertEquals(1,schedule.getSearchOptions().size());
        Assert.assertEquals(1, schedule.getSearchOptions().stream().findFirst().get().getRules().size());
    }


    @Test
    public void test_addOrRemoveGameToSearchSektorBAndSektorBForDifferentGames_ContainsTwoSearchOptionWithOnlySektorB() {
        //Arrange
        RblParserSchedule schedule = new RblParserSchedule();
        RBLGameToSearch gameToSearch = new RBLGameToSearch();
        gameToSearch.setName("RB Leipzig-Hertha BSC");
        gameToSearch.setSektor("B");
        gameToSearch.setAktiv(true);
        schedule.addOrRemoveGameToSearch(gameToSearch);

        //Act
        RBLGameToSearch gameToRemoveSearch = new RBLGameToSearch();
        gameToRemoveSearch.setName("RB Leipzig-SC Münchaurach");
        gameToRemoveSearch.setSektor("B");
        gameToRemoveSearch.setAktiv(true);
        schedule.addOrRemoveGameToSearch(gameToRemoveSearch);

        //Assert
        Assert.assertEquals(2,schedule.getSearchOptions().size());
        Assert.assertEquals(1, schedule.getSearchOptions()
                .stream()
                .filter(game->game.name.equals("RB Leipzig-Hertha BSC"))
                .findFirst()
                .get().getRules().size());
        Assert.assertEquals(1, schedule.getSearchOptions()
                .stream()
                .filter(game->game.name.equals("RB Leipzig-SC Münchaurach"))
                .findFirst()
                .get().getRules().size());
    }

    @Test
    public void test_addOrRemoveGameToSearchSektorBAndSektorBForDifferentGamesAfterThatRemoveBForSecondGame_ContainsTwoSearchOptionOnlyOneWithOnlySektorB() {
        //Arrange
        RblParserSchedule schedule = new RblParserSchedule();
        RBLGameToSearch gameToSearch = new RBLGameToSearch();
        gameToSearch.setName("RB Leipzig-Hertha BSC");
        gameToSearch.setSektor("B");
        gameToSearch.setAktiv(true);
        schedule.addOrRemoveGameToSearch(gameToSearch);

        //Act
        RBLGameToSearch gameToRemoveSearch = new RBLGameToSearch();
        gameToRemoveSearch.setName("RB Leipzig-SC Münchaurach");
        gameToRemoveSearch.setSektor("B");
        gameToRemoveSearch.setAktiv(true);
        schedule.addOrRemoveGameToSearch(gameToRemoveSearch);
        gameToRemoveSearch.setAktiv(false);
        schedule.addOrRemoveGameToSearch(gameToRemoveSearch);

        //Assert
        Assert.assertEquals(1,schedule.getSearchOptions().size());
        Assert.assertEquals(1, schedule.getSearchOptions()
                .stream()
                .filter(game->game.name.equals("RB Leipzig-Hertha BSC"))
                .findFirst()
                .get().getRules().size());
        Assert.assertEquals(false, schedule.getSearchOptions()
                .stream()
                .filter(game->game.name.equals("RB Leipzig-SC Münchaurach"))
                .findFirst()
                .isPresent());
    }


    @Test
    public void test_addOrRemoveGameToSearchSektorBAndSektorBForDifferentGamesAfterThatASektorDACForGameTwo_ContainsTwoSearchOptionWithOnlySektorB() {
        //Arrange
        RblParserSchedule schedule = new RblParserSchedule();
        RBLGameToSearch gameToSearch = new RBLGameToSearch();
        gameToSearch.setName("RB Leipzig-Hertha BSC");
        gameToSearch.setSektor("B");
        gameToSearch.setAktiv(true);
        schedule.addOrRemoveGameToSearch(gameToSearch);

        //Act
        RBLGameToSearch gameToRemoveSearch = new RBLGameToSearch();
        gameToRemoveSearch.setName("RB Leipzig-SC Münchaurach");
        gameToRemoveSearch.setSektor("B");
        gameToRemoveSearch.setAktiv(true);
        schedule.addOrRemoveGameToSearch(gameToRemoveSearch);

        gameToRemoveSearch.setSektor("A");
        schedule.addOrRemoveGameToSearch(gameToRemoveSearch);
        gameToRemoveSearch.setSektor("C");
        schedule.addOrRemoveGameToSearch(gameToRemoveSearch);
        gameToRemoveSearch.setSektor("D");
        schedule.addOrRemoveGameToSearch(gameToRemoveSearch);

        //Assert
        Assert.assertEquals(2,schedule.getSearchOptions().size());
        Assert.assertEquals(1, schedule.getSearchOptions()
                .stream()
                .filter(game->game.name.equals("RB Leipzig-Hertha BSC"))
                .findFirst()
                .get().getRules().size());
        Assert.assertEquals(4, schedule.getSearchOptions()
                .stream()
                .filter(game->game.name.equals("RB Leipzig-SC Münchaurach"))
                .findFirst()
                .get().getRules().size());
    }
}
