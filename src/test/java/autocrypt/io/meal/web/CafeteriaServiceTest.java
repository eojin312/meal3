package autocrypt.io.meal.web;

import autocrypt.io.meal.domain.Cafeteria;
import autocrypt.io.meal.domain.CafeteriaDto;
import autocrypt.io.meal.repository.CafeteriaRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CafeteriaServiceTest {
    public static final String GOOGLE = "https://www.google.com/search?rlz=1C5CHFA_enKR926KR926&tbs=lrf:!1m4!1u2!2m2!2m1!1e1!1m4!1u1!2m2!1m1!1e1!1m4!1u1!2m2!1m1!1e2!1m4!1u3!2m2!3m1!1e1!1m5!1u2!2m2!2m1!2e9!4e2!2m1!1e2!2m1!1e3!3sIAE,lf:1,lf_ui:9&tbm=lcl&sxsrf=ALeKk02QdDKr7Xzj-VJs6yh147-htflZBg:1605501529330&q=%EC%97%AC%EC%9D%98%EB%8F%84%EC%97%AD%20%EB%A7%9B%EC%A7%91&rflfq=1&num=10&sa=X&ved=2ahUKEwjj6N2in4btAhVZVN4KHREwBKcQjGp6BAgMEFA&biw=1920&bih=891&rlfi=hd:;si:&rlst=f&rlvp=clear";
    @Autowired
    private CafeteriaService cafeteriaService;

    @BeforeEach
    void setup() throws IOException {
        Document document = Jsoup.connect(GOOGLE).get();
        Elements elements = document.select("div.VkpGBb");
        for (Element element : elements) {
            String name = element.select("div.dbg0pd").text();
            String grade = element.select("div.BTtC6e").text();
            Cafeteria save = cafeteriaService.save(CafeteriaDto.Create.builder()
                    .name(name)
                    .created(LocalDateTime.now())
                    .updated(LocalDateTime.now())
                    .build());
            Assertions.assertNotNull(save);
            System.out.println(grade);
        }
    }

    @Test
    void 랜덤식당_잘나오는_테스트() throws IOException {
        Assertions.assertNotNull(cafeteriaService.randomId());
    }

    @Test
    void 식당_입력_테스트() throws IOException {
        Cafeteria cafeteria = cafeteriaService.save(CafeteriaDto.Create.builder()
                .name("칼국수")
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build()
        );
        Assertions.assertNotNull(cafeteria);
    }
}