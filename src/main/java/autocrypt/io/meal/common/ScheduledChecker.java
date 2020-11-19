package autocrypt.io.meal.common;

import autocrypt.io.meal.web.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ScheduledChecker {

    private final MailService mailService;

    @Scheduled(cron = "0 30 11 ? * MON-FRI")
    public void reservation() throws IOException, MessagingException {
        mailService.sendMail();
    }
}
