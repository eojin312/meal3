package autocrypt.io.meal.web;

import autocrypt.io.meal.domain.Cafeteria;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CafeteriaController {

    private final CafeteriaService cafeteriaService;

    /**
     * 일단은 리턴을 Cafeteria 로 설정한다
     * @return
     */
    @GetMapping("/")
    public Optional<Cafeteria> randomId() {
        return cafeteriaService.randomId();
    }
}
