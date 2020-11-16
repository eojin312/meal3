package autocrypt.io.meal.domain;

import autocrypt.io.meal.web.CafeteriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.IOException;

@Service
@Transactional
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;
    private final CafeteriaService cafeteriaService;

    public void sendMail(String to) throws MessagingException, IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("smail@autocrypt.io");
        mimeMessageHelper.setSubject("오늘의 점심 입니다!");
        mimeMessageHelper.setTo(to.split(","));
        mimeMessageHelper.setText(cafeteriaService.randomId() + "이거 드세요!@");
    }
}
