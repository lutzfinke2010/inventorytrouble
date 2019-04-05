package de.maxya.inventorytrouble.control.login;

import com.gargoylesoftware.htmlunit.html.HTMLParserListener;

import java.net.URL;

public class SilentHtmlParserListener implements HTMLParserListener {
    @Override
    public void error(String s, URL url, String s1, int i, int i1, String s2) {
    }

    @Override
    public void warning(String s, URL url, String s1, int i, int i1, String s2) {
    }
}
