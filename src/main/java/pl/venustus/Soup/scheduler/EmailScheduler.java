/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package pl.venustus.Soup.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.venustus.Soup.config.AdminConfig;
import pl.venustus.Soup.domain.Mail;
import pl.venustus.Soup.repository.OfferRepository;
import pl.venustus.Soup.service.SimpleEmailService;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Offers details.";
    @Autowired
    private SimpleEmailService simpleEmailService;
    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        long size = offerRepository.count();
        simpleEmailService.send(new Mail(
                //"venustus.pl@gmail.com",
                adminConfig.getAdminMail(),
                SUBJECT,
                "Currently in database you got: " + size + (size > 1 ? " offers." : " offer.")
        ));
    }
}