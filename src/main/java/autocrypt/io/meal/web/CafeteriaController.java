package autocrypt.io.meal.web;

import autocrypt.io.meal.domain.Cafeteria;
import autocrypt.io.meal.domain.CafeteriaDto;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CafeteriaController {
    public static final String GOOGLE = "https://www.google.com/search?rlz=1C5CHFA_enKR926KR926&tbs=lrf:!1m4!1u2!2m2!2m1!1e1!1m4!1u1!2m2!1m1!1e1!1m4!1u1!2m2!1m1!1e2!1m4!1u3!2m2!3m1!1e1!1m5!1u2!2m2!2m1!2e9!4e2!2m1!1e2!2m1!1e3!3sIAE,lf:1,lf_ui:9&tbm=lcl&sxsrf=ALeKk02QdDKr7Xzj-VJs6yh147-htflZBg:1605501529330&q=%EC%97%AC%EC%9D%98%EB%8F%84%EC%97%AD%20%EB%A7%9B%EC%A7%91&rflfq=1&num=10&sa=X&ved=2ahUKEwjj6N2in4btAhVZVN4KHREwBKcQjGp6BAgMEFA&biw=1920&bih=891&rlfi=hd:;si:&rlst=f&rlvp=clear";

    private final CafeteriaService cafeteriaService;

    @PostMapping("/save")
    public Cafeteria save() throws IOException {
        Cafeteria save = new Cafeteria();
        Document document = Jsoup.connect(GOOGLE).get();
        Elements elements = document.select("div.VkpGBb");
        for (Element element : elements) {
            String name = element.select("div.dbg0pd").text();
            save = cafeteriaService.save(CafeteriaDto.Create.builder()
                    .name(name)
                    .created(LocalDateTime.now())
                    .updated(LocalDateTime.now())
                    .build());
        }
        return save;
    }

    /**
     * 일단은 리턴을 Cafeteria 로 설정한다
     * @return
     */
    @GetMapping("/list")
    public Optional<CafeteriaDto.Create> randomId() {
        return cafeteriaService.randomId();
    }
}
