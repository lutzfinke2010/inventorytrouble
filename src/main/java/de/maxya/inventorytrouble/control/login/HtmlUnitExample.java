package de.maxya.inventorytrouble.control.login;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class HtmlUnitExample {

    public String loadTicketboerse() throws IOException {
        return login();
    }

    private String login() throws IOException {
        final WebClient webClient = new WebClient();
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        String url = "http://tickets.dierotenbullen.com/shop?wes=empty_session_111&language=1&shopid=111&nextstate=8a&backloginstate=2";

        final HtmlPage page1 = webClient.getPage(url);
        System.out.println("Page1: " + page1.toString());

        List<HtmlForm> forms = page1.getForms();
        if (forms.size() > 0) {
            System.out.println("Count of Forms: " + forms.size());
        }

        final HtmlForm form = forms.get(0);
        System.out.println("Count of FormElements: " + form.getLostChildren().size());

        Iterator var3 = form.getElementsByTagName("button").iterator();

        while (var3.hasNext()) {
            HtmlElement elt = (HtmlElement) var3.next();
            if (elt instanceof HtmlButton) {
                HtmlButton submit = ((HtmlButton) elt);
                System.out.println("HtmlButton found: " + submit.getAttribute("type"));
                if (submit != null) {
                    final HtmlTextInput textField = form.getInputByName("kundennr");
                    textField.setValueAttribute("ebaykleinanzeigenmaxmueller@gmail.com");
                    final HtmlPasswordInput textFieldpass = form.getInputByName("passwort");
                    textFieldpass.setValueAttribute("maxmueller123");
                    final HtmlPage page2 = submit.click();

                    //secondPage
                    DomElement domelement = page2.getElementById("navbarAccountDropdown");
                    System.out.println("Name:" + domelement.getNodeValue());


                    Iterator elements = domelement.getChildElements().iterator();

                    while (elements.hasNext()) {
                        DomElement currenElement = (DomElement) elements.next();
                        currenElement.getNodeValue();
                    }

                    List<Object> scripte = page2.getByXPath("//script[@type='application/ld+json']");

                    Iterator scripteIterator = scripte.iterator();

                    while (scripteIterator.hasNext()) {
                        DomElement currenElement = (DomElement) scripteIterator.next();
                        if ("".equals(currenElement.getAttribute("type"))) {
                            System.out.println("json:" + currenElement.getNodeValue());
                        } else {
                            String type = currenElement.getAttribute("type");
                            System.out.println("type:" + type);
                        }
                    }
                    DomElement stateloader = page2.getElementById("state-loader");
                    String dataURL = stateloader.getAttribute("data-url");

                    HtmlPage page3 = webClient.getPage("https://tickets.dierotenbullen.com/" + dataURL);

                    List<HtmlAnchor> anchorsList = page3.getAnchors();
                    Iterator anchorsIterator = anchorsList.iterator();

                    while (anchorsIterator.hasNext()) {
                        HtmlAnchor anchor = (HtmlAnchor) anchorsIterator.next();
                        if (anchor.hasAttribute("data-block-link-anchor")) {
                            if ("2955".equals(anchor.getAttribute("data-performanceid"))) {
                                HtmlPage page4 = webClient.getPage("https://tickets.dierotenbullen.com/" + anchor.getHrefAttribute());
                                return page4.asXml();
                            }
                        }
                    }

                    return page3.asXml();
                }
                break;
            } else {
                System.out.println("TypeOf : " + elt.getNodeName());
            }
        }


/*
        final HtmlSubmitInput button = (HtmlSubmitInput) form.getInputsByValue("Anmelden").get(0);
        if (button != null) {
            System.out.println("HTML Submit-Button: " + button.getClass().getName());
        }

        final HtmlTextInput textField = form.getInputByName("email");
        textField.setValueAttribute("jon@jon.com");
        final HtmlTextInput textFieldpass = form.getInputByName("pass");
        textFieldpass.setValueAttribute("ahhhh");
        final HtmlPage page2 = button.click();
        return page2.toString();
*/
        return "";
    }
}
