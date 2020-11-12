package autocrypt.io.meal.repository;

import autocrypt.io.meal.domain.Cafeteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeteriaRepository extends JpaRepository<Cafeteria, Integer> {
}
