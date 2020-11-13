package autocrypt.io.meal.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CafeteriaDto {

    private String name;
    private String cuisine;
    private LocalDateTime created;
    private LocalDateTime updated;

    @Getter
    public static class Create {
        private int id;
        private String name;
        private String cuisine;
        private LocalDateTime created;
        private LocalDateTime updated;

        @Builder
        public Create(int id, String name, String cuisine, LocalDateTime created, LocalDateTime updated) {
            this.id = id;
            this.name = name;
            this.cuisine = cuisine;
            this.created = LocalDateTime.now();
            this.updated = LocalDateTime.now();
        }
        public Cafeteria toEntity() {
            return Cafeteria.builder()
                    .id(id)
                    .name(name)
                    .cuisine(cuisine)
                    .created(created)
                    .updated(updated)
                    .build();
        }

    }
}
