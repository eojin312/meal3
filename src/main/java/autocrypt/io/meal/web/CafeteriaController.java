package autocrypt.io.meal.web;

import autocrypt.io.meal.domain.CafeteriaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CafeteriaController {

    private final CafeteriaService cafeteriaService;

    /**
     * 일단은 리턴을 Cafeteria 로 설정한다
     *
     * @return
     */
    @GetMapping("/list")
    public Optional<CafeteriaDto.Create> randomId() throws IOException {
        return cafeteriaService.randomId();
    }
}
