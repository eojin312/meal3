package autocrypt.io.meal.repository;

import autocrypt.io.meal.domain.Cafeteria;
import autocrypt.io.meal.domain.CafeteriaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CafeteriaRepository extends JpaRepository<Cafeteria, Integer> {

    Optional<CafeteriaDto.Create> findNameById(int id);
}
