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

    @Scheduled(cron = "*/5 * * * *")
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