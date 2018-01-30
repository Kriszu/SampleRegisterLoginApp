/*

package com.kriszu.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ParseServiceImpl implements ParseService {

    @Override
    public void saveThreadsFromWp() throws IOException {
        String url = "https://tech.wp.pl/technologie-nauka";
        Document doc = Jsoup.connect(url).get();
        List<Document> documents = new ArrayList<Document>();
        List<Elements> content = new ArrayList<Elements>();
        List<List<String>> myList = new ArrayList<List<String>>();
        Elements titlesElements = doc.getElementsByAttributeValue("class", "_2PrHTUx"); // all elements
        List<String> hrefList = titlesElements.eachAttr("abs:href"); // hrefy od 1 do n



    }
}

*/
