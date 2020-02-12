package pl.venustus.Soup.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.venustus.Soup.domain.Offers;
import pl.venustus.Soup.domain.OffersDto;
import pl.venustus.Soup.repository.OffersRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class MainController {

    @Autowired
    OffersRepository offersRepository;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/api/offerscount")
    public String getOffersCount() {
        try {
            Document document = Jsoup.connect("https://www.pracuj.pl/praca/junior%20java%20developer;kw/warszawa;wp").get();
            Elements elements = document.getElementsByClass("results-header__offer-count-text-number");
            return elements.get(0).text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/api/offers")
    public List<String> getOffers() {
        try {
            List<String> result = new ArrayList();
            Document document = Jsoup.connect("https://www.pracuj.pl/praca/junior%20java%20developer;kw/warszawa;wp").get();
            Elements elements = document.select("a[class=offer-details__title-link]");
            for (Element element : elements) {
                result.add(element.ownText() + " - " + "https://pracuj.pl" + element.attr("href"));
            }

            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/api/savenewoffers")
    public Integer savenewoffers() {
        Integer i = 0;
        try {
            Document document = Jsoup.connect("https://www.pracuj.pl/praca/junior%20java%20developer;kw/warszawa;wp").get();
            Elements elements = document.select("a[class=offer-details__title-link]");
            for (Element element : elements) {
                offersRepository.save(modelMapper.map(new OffersDto(element.ownText(), ("https://pracuj.pl" + element.attr("href"))), Offers.class));
                i++;
            }
            return i;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

