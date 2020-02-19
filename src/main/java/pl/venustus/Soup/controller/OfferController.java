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
import pl.venustus.Soup.domain.Offer;
import pl.venustus.Soup.domain.OfferDto;
import pl.venustus.Soup.repository.OfferRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class OfferController {

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/api/online/offerscount")
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

    @GetMapping("/api/online/offers")
    public List<String> getOnlineOffers() {
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

    @GetMapping("/api/db/offers")
    public List<OfferDto> getDbOffers() {

        List<OfferDto> result;
        result = offerRepository.findAll().stream()
                .map(offer -> modelMapper.map(offer, OfferDto.class))
                .collect(Collectors.toList());

        return result;
    }

    @GetMapping("/api/savenewoffers")
    public Integer savenewoffers() {
        Integer i = 0;
        try {
            Document document = Jsoup.connect("https://www.pracuj.pl/praca/junior%20java%20developer;kw/warszawa;wp").get();
            Elements elements = document.select("a[class=offer-details__title-link]");
            LocalDateTime now = LocalDateTime.now();
            for (Element element : elements) {
                if (offerRepository.checkIfOfferExists("https://pracuj.pl" + element.attr("href")).size() <= 0) {
                    offerRepository.save(modelMapper.map(new OfferDto(element.ownText(), ("https://pracuj.pl" + element.attr("href")), now), Offer.class));
                    i++;
                }
            }
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}

