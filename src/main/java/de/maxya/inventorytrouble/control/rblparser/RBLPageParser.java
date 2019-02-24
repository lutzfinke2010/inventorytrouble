package de.maxya.inventorytrouble.control.rblparser;

import de.maxya.inventorytrouble.boundary.InventoryTroubleApiImpl;
import de.maxya.inventorytrouble.boundary.model.RBLGames;
import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Service
public class RBLPageParser {

    private String basePath = "https://tickets.dierotenbullen.com/online/index.php";
    private boolean warteRaumm = false;

    public List<RBLGames> getAvaiableGames() {
        return avaiableGames;
    }

    private List<RBLGames> avaiableGames;

    public RBLPageParser(){
        avaiableGames = new ArrayList<>();
    }

    public boolean isInWarteRaum(){
        return warteRaumm;
    }


    public List<RBLGames> extractFreePlaces(){
        List<RBLGames> gameNeu = new ArrayList<>();
        List<RBLGames> games = extractTicketboerse();
        for (Iterator it = games.iterator(); it.hasNext(); ) {
            RBLGames game = extractRblGame(it);
            gameNeu.add(game);
        }
        return gameNeu;
    }

    private RBLGames extractRblGame(Iterator it) {
        RBLGames game = (RBLGames) it.next();
        try {
            Document doc = getDocumentFromLink(game.getLink());
            Elements trs = doc.select("tr");
            for (Iterator itE = trs.iterator(); itE.hasNext(); ) {
                Element element = (Element) itE.next();
                Elements tds = element.select("td");
                if (tds.size() > 0) {
                    RBLSitzplatz platz = extractRblSitzplatz(tds);
                    game.getPlaetze().add(platz);
                }
            }
        } catch (IOException ex) {
            //...
        }
        return game;
    }

    private RBLSitzplatz extractRblSitzplatz(Elements tds) {
        RBLSitzplatz platz = new RBLSitzplatz();
        int index = 0;
        for (Iterator itPlaces = tds.iterator(); itPlaces.hasNext(); ) {
            Element place = (Element) itPlaces.next();
            String data = place.text();
            if (index == 0) {
                platz.setBereich(data);
            } else if (index == 1) {
                platz.setReihe(data);
            } else if (index == 2) {
                platz.setSitz(data);
            } else if (index == 3) {
                platz.setKategorie(data);
            } else {
                break;
            }
            index++;
        }
        return platz;
    }

    private Document getDocumentFromLink(String link) throws IOException {
        return Jsoup.connect(link).get();
    }

    public List<RBLGames> extractTicketboerse() {
        avaiableGames = extractAvaiableGames();
        List<RBLGames> ret = new ArrayList<RBLGames>();
        for (Iterator it = avaiableGames.iterator(); it.hasNext(); ) {
            RBLGames game = (RBLGames) it.next();
            try {
                Document doc = getDocumentFromLink(game.getLink());

                Elements links = doc.select("a[class='btn btn-primary btn-block']");
                for (Iterator itE = links.iterator(); itE.hasNext(); ) {
                    Element element = (Element) itE.next();
                    Attributes attr = element.attributes();
                    String href = attr.get("href");
                    game.setLink(basePath + href);
                    ret.add(game);
                }
            } catch (IOException ex) {
                //...
            }
        }
        return ret;
    }

    private static final Logger LOGGER = LogManager.getLogger(InventoryTroubleApiImpl.class);

    public Date convert(String datum) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.ENGLISH);
        Date date = format.parse(datum);
        return date;
    }

    public List<RBLGames> extractAvaiableGames() {
        List<RBLGames> games = new ArrayList<RBLGames>();
        try {
            String blogUrl = "https://tickets.dierotenbullen.com/online/index.php3?shopid=111";
            Document doc = getDocumentFromLink(blogUrl);
            warteRaumm = false;
            if ( doc.title().contains("Warteraum") ){
                warteRaumm = true;
                return new ArrayList<RBLGames>();
            }
            Elements links = doc.select("script[type='application/ld+json']");
            Object[] array = links.toArray();
            for (int i = 0; i < array.length; i++) {
                Element x = (Element) array[i];
                JSONObject obj = new JSONObject(x.data());
                String name = obj.getString("name");
                String url = obj.getString("url");
                String date = obj.getString("startDate");
                RBLGames game = new RBLGames();
                game.setLink(url);
                game.setName(name);
                games.add(game);
                try{
                    game.setStartDate(convert(date));
                }catch(Exception ex){
                }
            }
            return games;
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR,ex);
        }
        return new ArrayList<RBLGames>();
    }
}
