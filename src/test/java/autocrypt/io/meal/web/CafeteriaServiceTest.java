package autocrypt.io.meal.web;

import autocrypt.io.meal.domain.Cafeteria;
import autocrypt.io.meal.repository.CafeteriaRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CafeteriaServiceTest {

    @Autowired
    private CafeteriaService cafeteriaService;

    @Autowired
    private CafeteriaRepository cafeteriaRepository;

    @BeforeEach
    void setUp() {
        Cafeteria cafeteria = cafeteriaRepository.save(Cafeteria
                .builder()
                .name("빅맥")
                .cuisine("맥도날드")
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build()
        );
        cafeteriaRepository.save(Cafeteria
                .builder()
                .name("마라탕")
                .cuisine("마라도나")
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build()
        );

        cafeteriaRepository.save(Cafeteria
                .builder()
                .name("콜라")
                .cuisine("편의점")
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build()
        );
        cafeteriaRepository.save(Cafeteria
                .builder()
                .name("청국장")
                .cuisine("고깃집")
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build()
        );
        cafeteriaRepository.save(Cafeteria
                .builder()
                .name("핫도그")
                .cuisine("서브웨이")
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build()
        );
        cafeteriaRepository.save(Cafeteria
                .builder()
                .name("카레")
                .cuisine("아비꼬")
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build()
        );
        cafeteriaRepository.save(Cafeteria
                .builder()
                .name("백반")
                .cuisine("지하")
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build()
        );
        cafeteriaRepository.save(Cafeteria
                .builder()
                .name("만둣국")
                .cuisine("다른 지하")
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build()
        );
        cafeteriaRepository.save(Cafeteria
                .builder()
                .name("마라탕")
                .cuisine("마라도나")
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build()
        );
    }

    @Test
    void 랜덤식당_잘나오는_테스트() {
        Assertions.assertNotNull(cafeteriaService.randomId());
    }
}