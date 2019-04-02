package de.maxya.inventorytrouble.control.login;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpUrlConnectionExample {

    public HttpUrlConnectionExample() {
    }

    private List<String> cookies;
    private HttpsURLConnection conn;

    private final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.75 Safari/537.36";
    private String wes = "";
    private String shopId = "";
    private String nextState = "";

    public String login() throws Exception, WarteRaumException {

        String url = "https://tickets.dierotenbullen.com/shop?wes=empty_session_111&language=1&shopid=111&nextstate=8a&backloginstate=2";

        // make sure cookies is turn on
        CookieHandler.setDefault(new CookieManager());

        // 1. Send a "GET" request, so that you can extract the form's data.
        String page = GetPageContent(url);

        if (page.contains("Warteraum")){
            throw new WarteRaumException();
        }

        String postParams = getFormParams(page, "ebaykleinanzeigenmaxmueller@gmail.com", "maxmueller123");
//        String postParams = getFormParams(page, "asdf@gmail.com", "asdf");

        // 2. Construct above post's content and then send a POST request for
        // authentication
        sendPost(url, postParams);

        // 3. success then go to gmail.
        String gmail = "https://tickets.dierotenbullen.com/shop?wes=" + wes + "&shopid=" + shopId + "&nextstate=" + nextState;
        System.out.println("Adress:" + gmail);

        String result = GetPageContent(gmail);
        System.out.println(result);
        return result;
    }

    private void sendPost(String url, String postParams) throws Exception {

        URL obj = new URL(url);
        conn = (HttpsURLConnection) obj.openConnection();

        // Acts like a browser
        conn.setUseCaches(false);
        conn.setRequestMethod("POST");
        /*
        Cache-Control: must-revalidate, no-cache, no-store, private
        Cache-Control: no-cache
        Connection: keep-alive
        Content-Encoding: gzip
        Content-Length: 7367
        Content-Security-Policy: frame-ancestors ticketing03.cld.ondemand.com tickets.dierotenbullen.com tickets.dierotenbullen.com
        Content-Type: text/html; charset=ISO-8859-1
        Date: Sat, 23 Mar 2019 21:07:28 GMT
        Expires: 0
        Pragma: no-cache
        Server: Apache
        Set-Cookie: sap-et-CSRFTokenCookie-678a07b9cb92118c0b50b6fea667d389=9921fefaa44801bd0caf92966c3ecec3; path=/; domain=.dierotenbullen.com; secure; httponly
        Strict-Transport-Security: max-age=86400; includeSubDomains
        Vary: Accept-Encoding
        X-Content-Type-Options: nosniff
        X-XSS-Protection: 1
        
         */

        conn.setRequestProperty("Cache-Control", "must-revalidate, no-cache, no-store, private");
        conn.setRequestProperty("Cache-Control", "no-cache");
        conn.setRequestProperty("Connection", "keep-alive");
        conn.setRequestProperty("Content-Encoding", "gzip");
        conn.setRequestProperty("Content-Length", Integer.toString(postParams.length()));
        conn.setRequestProperty("Content-Security-Policy", "frame-ancestors ticketing03.cld.ondemand.com tickets.dierotenbullen.com tickets.dierotenbullen.com");
        conn.setRequestProperty("Content-Type", "text/html; charset=ISO-8859-1");
        conn.setRequestProperty("Date", "Sat, 23 Mar 2019 21:07:28 GMT");
        conn.setRequestProperty("Expires", "0");
        conn.setRequestProperty("Pragma", "no-cache");
        conn.setRequestProperty("Server", "Apache");
        conn.setRequestProperty("Set-Cookie", "sap-et-CSRFTokenCookie-678a07b9cb92118c0b50b6fea667d389=9921fefaa44801bd0caf92966c3ecec3; path=/; domain=.dierotenbullen.com; secure; httponly");
        conn.setRequestProperty("Strict-Transport-Security", "max-age=86400; includeSubDomains");
        conn.setRequestProperty("Vary", "Accept-Encoding");
        conn.setRequestProperty("X-Content-Type-Options", "nosniff");
        conn.setRequestProperty("X-XSS-Protection", "1");

        //OLD
        conn.setRequestProperty("User-Agent", USER_AGENT);

//       /* conn.setRequestProperty("Host", "tickets.dierotenbullen.com");
//        conn.setRequestProperty("Accept",
//                "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
//        conn.setRequestProperty("Accept-Language", "de-DE,de;q=0.9,en-US;q=0.8,en;q=0.7");
//        conn.setRequestProperty("Set-Cookie", "sap-et-CSRFTokenCookie-678a07b9cb92118c0b50b6fea667d389=e68548b2cdba05d4afd50933b27ddcc3; path=/; domain=.dierotenbullen.com; secure; httponly");
//        conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
//        conn.setRequestProperty("Cache-Control", "max-age=0");
//        for (String cookie : this.cookies) {
//            conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
//        }
//        conn.setRequestProperty("Connection", "keep-alive");
//        conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
//        conn.setRequestProperty("Referer", "https://tickets.dierotenbullen.com/shop?wes=" + wes + "&shopid=" + shopId + "&nextstate=8a&backloginstate=5");
//        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//        conn.setRequestProperty("Content-Security-Policy", "frame-ancestors ticketing03.cld.ondemand.com tickets.dierotenbullen.com tickets.dierotenbullen.com");
//        conn.setRequestProperty("Content-Length", Integer.toString(postParams.length()));
//        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.75 Safari/537.36");*/
//
        conn.setDoOutput(true);
        conn.setDoInput(true);

        // Send post request
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(postParams);
        wr.flush();
        wr.close();

        int responseCode = conn.getResponseCode();
        String responseMessage = conn.getResponseMessage();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + postParams);
        System.out.println("Response Code : " + responseCode);
        System.out.println("Response Message : " + responseMessage);

        BufferedReader in =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        // System.out.println(response.toString());

    }

    private String GetPageContent(String url) throws Exception {

        URL obj = new URL(url);
        conn = (HttpsURLConnection) obj.openConnection();

        // default is GET
        conn.setRequestMethod("GET");

        conn.setUseCaches(false);

        // act like a browser
        conn.setRequestProperty("User-Agent", USER_AGENT);
        conn.setRequestProperty("Accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        if (cookies != null) {
            for (String cookie : this.cookies) {
                conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
            }
        }
        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Get the response cookies
        setCookies(conn.getHeaderFields().get("Set-Cookie"));

        return response.toString();

    }

    public String getFormParams(String html, String username, String password)
            throws UnsupportedEncodingException {

        System.out.println("Extracting form's data...");

        Document doc = Jsoup.parse(html);

        // Google form id
        Element loginform = doc.getElementsByAttribute("method").first();
        Elements inputElements = loginform.getElementsByTag("input");
        List<String> paramList = new ArrayList<String>();
        for (Element inputElement : inputElements) {
            String key = inputElement.attr("name");
            String value = inputElement.attr("value");

            if (key.equals("kundennr"))
                value = username;
            else if (key.equals("passwort"))
                value = password;
            else if (key.equals("wes")) {
                wes = value.toString();
            } else if (key.equals("nextstate")) {
                nextState = value.toString();
            } else if (key.equals("shopid")) {
                shopId = value.toString();
            }
            paramList.add(key + "=" + value);
//            paramList.add(key + "=" + URLEncoder.encode(value, "UTF-8"));
        }

        // build parameters list
        StringBuilder result = new StringBuilder();
        for (String param : paramList) {
            if (result.length() == 0) {
                result.append(param);
            } else {
                result.append("&" + param);
            }
        }
        return result.toString();
    }

    public List<String> getCookies() {
        return cookies;
    }

    public void setCookies(List<String> cookies) {
        this.cookies = cookies;
    }

}
