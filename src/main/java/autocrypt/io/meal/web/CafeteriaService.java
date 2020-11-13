package autocrypt.io.meal.web;

import autocrypt.io.meal.domain.Cafeteria;
import autocrypt.io.meal.repository.CafeteriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CafeteriaService {

    private final CafeteriaRepository cafeteriaRepository;

    int randomCafeteria = 0;

    public Optional<Cafeteria> randomId() {
        List<Cafeteria> cafeteriaList = new ArrayList<>();
        randomCafeteria = (int) (Math.random() * 10);
        if (randomCafeteria == 0) {
            System.out.println("스킵..");
        }
        Optional<Cafeteria> cafeteria = cafeteriaRepository.findNameById(randomCafeteria);
        return cafeteria;
    }


}
