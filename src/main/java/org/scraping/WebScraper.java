package org.scraping;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;

import java.io.IOException;

public class WebScraper {
    WebClient webClient = new WebClient();
    HtmlPage page;

    public WebScraper() throws IOException {
        String url = "https://www.breizhchrono.com/detail-de-la-course/roazhonrun-roazhonnocturnemgen-2022-15101/coureur_search/Petremoul";
        page = getWebPage(url);
    }

    private HtmlPage getWebPage(String url) throws IOException {
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        return webClient.getPage(url);
    }

    /**
     * Méthode en charge d'extraire les informations d'un coureur dans un tableau
     *
     * @param table   représente le tableau
     * @param coureur représente le coureur
     */
    public void extraireInformation(HtmlTable table, Coureur coureur) {
        coureur.setClassement(Integer.parseInt(table.getCellAt(1, 0).asNormalizedText()));
        coureur.setNom(table.getCellAt(1, 1).asNormalizedText());
        coureur.setCategorie(table.getCellAt(1, 2).asNormalizedText());
        coureur.setCategorie(table.getCellAt(1, 2).asNormalizedText());
        coureur.setSexe(table.getCellAt(1, 3).asNormalizedText());
        if ((table.getCellAt(1, 4).asNormalizedText()) != "") {
            coureur.setClub(table.getCellAt(1, 4).asNormalizedText());
        }
        coureur.setTemps(table.getCellAt(1, 5).asNormalizedText());
    }
}

