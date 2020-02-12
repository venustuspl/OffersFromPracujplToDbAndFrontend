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
            Elements elements = document.select("a[class=offer-details__title-link]");
            //System.out.println(elements);
            for (Element element : elements) {
                System.out.println(element.getElementsByAttribute("href"));
            }
            elements.stream()
                    .map(e -> ("https://pracuj.pl" + e.attr("href")))
                    .forEach(System.out::println);

            System.out.println("End");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
