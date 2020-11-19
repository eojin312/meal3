package autocrypt.io.meal.domain;

import autocrypt.io.meal.web.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootTest
class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    void sendMail() throws IOException, MessagingException {
        mailService.sendMail();
    }
}