package de.maxya.inventorytrouble.control.login;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import de.maxya.inventorytrouble.boundary.InventoryTroubleApiImpl;
import de.maxya.inventorytrouble.boundary.model.RBLGames;
import de.maxya.inventorytrouble.boundary.model.RBLSitzplatz;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RblScannerHtmlUnit {

    @Autowired
    UserDataService userDataService;

    UserData userData;

    private WebClient webClient;
    private String shortbaseUrl = "http://tickets.dierotenbullen.com";
    private String baseUrl = shortbaseUrl + "/shop";
    private List<RBLGames> listOfGames;
    private HtmlPage pageAfterLogin;
    private boolean loggedIn;

    public RblScannerHtmlUnit(){
        loggedIn = false;
    }

    public List<RBLGames> getAvaiableGames(){
        return listOfGames;
    }

    public void setUserDataService(UserDataService userDataService){
        this.userDataService = userDataService;
    }

    public String loadTicketboerse() throws IOException {

        Iterator<RBLGames> gamesIt = listOfGames.iterator();

        while(gamesIt.hasNext()){
            RBLGames game = gamesIt.next();
            if (game.getName().toLowerCase().trim().startsWith("rb leipzig")) {
                HtmlPage pageStartpageForGame = openStartPageForGameById(pageAfterLogin, game.getGameId());
                if (pageStartpageForGame != null) {
                    HtmlPage ticketboerse = openTicketboerse(pageStartpageForGame);
                    List<RBLSitzplatz> extractPlaces = extractFreePlaces(ticketboerse);
                    game.setPlaetze(extractPlaces);
                    System.out.println("Game:" + game.getName() + " Count Places: " + game.getPlaetze().size());
                }else{
                    System.out.println("StartPage from " + game.getName() + " is null!");
                }
            }
        }

        return pageAfterLogin.asXml();
    }

    public void refreshLogin() throws IOException {
        initWebClient();
        listOfGames = extractAvaiableGames();
        pageAfterLogin = login();
        if (pageAfterLogin != null){
            loggedIn = true;
        }
    }

    private void initWebClient() {
        listOfGames = new ArrayList<>();
        webClient = new WebClient();
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.setHTMLParserListener(new SilentHtmlParserListener());
    }

    private static final Logger LOGGER = LogManager.getLogger(InventoryTroubleApiImpl.class);

    public Date convert(String datum) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.ENGLISH);
        Date date = format.parse(datum);
        return date;
    }

    private List<RBLGames> extractAvaiableGames() throws IOException {
        HtmlPage page = webClient.getPage(shortbaseUrl);
        List<RBLGames> games = new ArrayList<RBLGames>();

        String content = page.asXml();

        List<HtmlScript> elements = page.getByXPath("//script[@type='application/ld+json']");
        Iterator<HtmlScript> array = elements.iterator();
        while(array.hasNext()) {
            HtmlScript x = array.next();
            HtmlElement o = (HtmlElement)x;
            JSONObject obj = new JSONObject(o.getChildren().iterator().next().asXml());
            String name = obj.getString("name");
            String url = obj.getString("url");
            if (name.toLowerCase().trim().startsWith("rb leipzig")) {
                String[] partsOfUrl = url.split("/");
                String id = partsOfUrl[partsOfUrl.length - 1];

                String date = obj.getString("startDate");
                RBLGames game = new RBLGames();
                game.setLink(url);
                game.setName(name);
                game.setGameId(id);
                games.add(game);
                try {
                    game.setStartDate(convert(date));
                } catch (Exception ex) {
                }
            }
        }
        return games;
    }

    private List<RBLSitzplatz> extractFreePlaces(HtmlPage ticketboerse) {
        List<RBLSitzplatz> plaetze = new ArrayList<>();
        HtmlTable table = (HtmlTable)(ticketboerse.getByXPath("//table").get(0));
        for ( int i = 1 ; i < table.getRowCount(); i++){
            HtmlTableRow row = table.getRow(i);
            String bereich = row.getCell(0).asText();
            String reihe = row.getCell(1).asText();
            String sitz = row.getCell(2).asText();
            String kategorie = row.getCell(3).asText();
            plaetze.add(RBLSitzplatz.createPlaceFromString(kategorie,bereich,reihe,sitz));
            System.out.println("Bereich: " + bereich + " Reihe: " + reihe + " Sitz: " + sitz);
        }
        return plaetze;
    }

    private HtmlPage openTicketboerse(HtmlPage startPage) throws IOException {
        List<HtmlAnchor> listOfAnchors = startPage.getAnchors();
        Iterator iteratorAnchors = listOfAnchors.iterator();
        while (iteratorAnchors.hasNext()){
            HtmlAnchor anchor = (HtmlAnchor)iteratorAnchors.next();
            String classes = anchor.getAttribute("class");
            if ("btn btn-primary btn-block".equals(classes)){
                String href = anchor.getHrefAttribute();
                String url = baseUrl + href;
                HtmlPage ticketboerse = webClient.getPage(url);
                return ticketboerse;
            }
        }
        return null;
    }

    private HtmlPage login() throws IOException {
        String url = "http://tickets.dierotenbullen.com/shop?wes=empty_session_111&language=1&shopid=111&nextstate=8a&backloginstate=2";

        userData = userDataService.getUserData();

        final HtmlPage page1 = webClient.getPage(url);

        List<HtmlForm> forms = page1.getForms();

        final HtmlForm form = forms.get(0);

        Iterator var3 = form.getElementsByTagName("button").iterator();

        HtmlPage pageAfterLogin = null;

        while (var3.hasNext()) {
            HtmlElement elt = (HtmlElement) var3.next();
            if (elt instanceof HtmlButton) {
                HtmlButton submit = ((HtmlButton) elt);
                if (submit != null) {
                    final HtmlTextInput textField = form.getInputByName("kundennr");
                    textField.setValueAttribute(userData.getName());
                    final HtmlPasswordInput textFieldpass = form.getInputByName("passwort");
                    textFieldpass.setValueAttribute(userData.getPasswort());
                    pageAfterLogin = submit.click();
                    break;
                }
            }
        }

        HtmlPage gameListAfterLogin = null;

        if (pageAfterLogin != null){
            DomElement stateloader = pageAfterLogin.getElementById("state-loader");
            String dataURL = stateloader.getAttribute("data-url");

            gameListAfterLogin = webClient.getPage("https://tickets.dierotenbullen.com/" + dataURL);
        }

        return gameListAfterLogin;
    }


    private HtmlPage openStartPageForGameById(HtmlPage page2, String playId) throws IOException {
        List<HtmlAnchor> anchorsList = page2.getAnchors();
        Iterator anchorsIterator = anchorsList.iterator();

        while (anchorsIterator.hasNext()) {
            HtmlAnchor anchor = (HtmlAnchor) anchorsIterator.next();
            if (anchor.hasAttribute("data-block-link-anchor")) {
                if (playId.equals(anchor.getAttribute("data-performanceid"))) {
                    HtmlPage page4 = webClient.getPage("https://tickets.dierotenbullen.com/" + anchor.getHrefAttribute());
                    return page4;
                }
            }
        }

        return null;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public UserData getUserData() {
        return userData;
    }


}
