package autocrypt.io.meal.domain;

import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Cafeteria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @Lob
    private String cuisine;
    private LocalDateTime created;
    private LocalDateTime updated;

    @Builder
    public Cafeteria(int id, String name, String cuisine, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.name = name;
        this.cuisine = cuisine;
        this.created = created;
        this.updated = updated;
    }

    public Cafeteria() {
    }
}
