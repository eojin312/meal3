package autocrypt.io.meal.domain;

import autocrypt.io.meal.web.CafeteriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;

/**
 * MailService
 */
@Service
@Transactional
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    private final CafeteriaService cafeteriaService;

    /**
     * mail 보내는 메소드
     * @throws MessagingException
     * @throws IOException
     * javaMailSender.send(mimeMessage);
     */
    public void sendMail() throws MessagingException, IOException {
        Optional<CafeteriaDto.Create> optionalCafeteria = cafeteriaService.randomId();
        if(optionalCafeteria.isPresent()) {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom("smail@autocrypt.io");
            mimeMessageHelper.setTo("ejlee@autocrypt.io");
            mimeMessageHelper.setSubject("오늘의 점심 입니다!");
            mimeMessageHelper.setText(optionalCafeteria.get().getName() + "이거 드세요!", false);
            javaMailSender.send(mimeMessage);
        }
    }
}
