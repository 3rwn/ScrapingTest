package org.scraping;

import com.gargoylesoftware.htmlunit.html.HtmlTable;

import java.io.IOException;


public class Main {

    private static final String username = "Petremoul";

    public static void main(String[] args) throws IOException {
        WebScraper webScraper = new WebScraper();

        final HtmlTable table = webScraper.page.getHtmlElementById("detail-course");
        Coureur coureur = new Coureur();

        webScraper.extraireInformation(table,coureur);

        System.out.println(webScraper.page.getTitleText());
        System.out.println(coureur);


    }
}
