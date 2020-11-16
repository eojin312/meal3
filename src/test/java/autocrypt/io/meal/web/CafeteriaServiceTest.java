package autocrypt.io.meal.web;

import autocrypt.io.meal.domain.Cafeteria;
import autocrypt.io.meal.domain.CafeteriaDto;
import autocrypt.io.meal.repository.CafeteriaRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CafeteriaServiceTest {

    @Autowired
    private CafeteriaService cafeteriaService;

    @Test
    void 랜덤식당_잘나오는_테스트() {
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