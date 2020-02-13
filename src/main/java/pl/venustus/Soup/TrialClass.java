package pl.venustus.Soup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrialClass {
    public static void main(String[] args) {
        try {
            List result = new ArrayList();
            Document document = Jsoup.connect("https://www.pracuj.pl/praca/junior%20java%20developer;kw/warszawa;wp").get();
            Elements elements = document.select("div[class=offer-details__text]");
            Elements elements1 = elements.select(".offer-company");
            System.out.println(elements.size());
            System.out.println(elements1.size());
            for (Element element : elements1) {
                System.out.println(element.getElementsByAttribute("href"));
                System.out.println(element.getElementsByAttribute("href.offer-company__name"));

            }

            System.out.println("End");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
