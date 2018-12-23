package de.maxya.inventorytrouble;

import de.maxya.inventorytrouble.boundary.model.RBLGames;
import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import de.maxya.inventorytrouble.control.RBLGameService;
import de.maxya.inventorytrouble.control.RBLGameServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import de.maxya.inventorytrouble.control.rblparser.RBLPageParser;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = InventorytroubleApplicationConfig.class, loader = AnnotationConfigContextLoader.class)
//@SpringBootTest
public class InventorytroubleApplicationTests {

    //@Test
    public void contextLoads() {
        RBLPageParser parser = new RBLPageParser();
        parser.extractFreePlaces();
    }

    public Date convert(String datum) throws ParseException {
        DateFormat format = new SimpleDateFormat("YYYY-MM-ddTHH:mm", Locale.ENGLISH);
        Date date = format.parse(datum);
        return date;
    }

    //@Test
    public void testGameSave(){
        try {
            RBLPageParser p = new RBLPageParser();
            Date d = p.convert("2018-10-25T18:55");
        } catch (ParseException e) {
        }
    }

}
