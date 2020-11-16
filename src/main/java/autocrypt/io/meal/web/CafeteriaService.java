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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CafeteriaService {

    private final CafeteriaRepository cafeteriaRepository;

    int randomCafeteria = 0;


    public Cafeteria save(CafeteriaDto.Create cafeteriaDto) throws IOException {
        return cafeteriaRepository.save(cafeteriaDto.toEntity());
    }

    public Optional<CafeteriaDto.Create> randomId() {
        List<Cafeteria> cafeteriaList = new ArrayList<>();
        randomCafeteria = (int) (Math.random() * 10);
        if (randomCafeteria == 0) {
            System.out.println("스킵..");
        }
        Optional<CafeteriaDto.Create> cafeteria = cafeteriaRepository.findNameById(randomCafeteria);
        return cafeteria;
    }
}
