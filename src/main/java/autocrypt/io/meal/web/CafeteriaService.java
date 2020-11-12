package autocrypt.io.meal.web;

import autocrypt.io.meal.domain.Cafeteria;
import autocrypt.io.meal.repository.CafeteriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CafeteriaService {

    private final CafeteriaRepository cafeteriaRepository;

    public Cafeteria randomId() {
        List<Cafeteria> cafeteriaList = new ArrayList<>();
        int randomCafeteria;
        randomCafeteria = (int) (Math.random() * cafeteriaList.size());
        return cafeteriaRepository.findById(randomCafeteria).orElseThrow();
    }
}
