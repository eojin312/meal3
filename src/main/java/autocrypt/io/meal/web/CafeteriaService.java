package autocrypt.io.meal.web;

import autocrypt.io.meal.domain.Cafeteria;
import autocrypt.io.meal.domain.CafeteriaDto;
import autocrypt.io.meal.repository.CafeteriaRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CafeteriaService {
    public static final String GOOGLE = "https://www.google.com/search?rlz=1C5CHFA_enKR926KR926&tbs=lrf:!1m4!1u2!2m2!2m1!1e1!1m4!1u1!2m2!1m1!1e1!1m4!1u1!2m2!1m1!1e2!1m4!1u3!2m2!3m1!1e1!1m5!1u2!2m2!2m1!2e9!4e2!2m1!1e2!2m1!1e3!3sIAE,lf:1,lf_ui:9&tbm=lcl&sxsrf=ALeKk02QdDKr7Xzj-VJs6yh147-htflZBg:1605501529330&q=%EC%97%AC%EC%9D%98%EB%8F%84%EC%97%AD%20%EB%A7%9B%EC%A7%91&rflfq=1&num=10&sa=X&ved=2ahUKEwjj6N2in4btAhVZVN4KHREwBKcQjGp6BAgMEFA&biw=1920&bih=891&rlfi=hd:;si:&rlst=f&rlvp=clear";
    private final CafeteriaRepository cafeteriaRepository;

    int randomCafeteria = 0;

    public Cafeteria save(CafeteriaDto.Create cafeteriaDto) {
        return cafeteriaRepository.save(cafeteriaDto.toEntity());
    }

    public Optional<CafeteriaDto.Create> randomId() throws IOException {
        // 크롤링한 가게 저장
        Document document = null;
        document = Jsoup.connect(GOOGLE).get();
        Elements elements = document.select("div.VkpGBb");
        for (Element element : elements) {
            String name = element.select("div.dbg0pd").text();
            save(CafeteriaDto.Create.builder()
                    .name(name)
                    .created(LocalDateTime.now())
                    .updated(LocalDateTime.now())
                    .build());
        }
        // 랜덤의 기준을 정하기 위해 findAll 을 이용해 list size 로 숫자를 random 의 기준을 정해준다
        List<Cafeteria> cafeteriaList = cafeteriaRepository.findAll();
        randomCafeteria = (int) (Math.random() * (cafeteriaList.size()-1)) + 1;

        Optional<CafeteriaDto.Create> cafeteria = cafeteriaRepository.findNameById(randomCafeteria);
        return cafeteria;

    }

}
