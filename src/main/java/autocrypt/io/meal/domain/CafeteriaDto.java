package autocrypt.io.meal.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CafeteriaDto {
    private String name;
    private LocalDateTime created;
    private LocalDateTime updated;

    @Getter
    public static class Create {
        private int id;
        private String name;
        private LocalDateTime created;
        private LocalDateTime updated;

        @Builder
        public Create(int id, String name, LocalDateTime created, LocalDateTime updated) {
            this.id = id;
            this.name = name;
            this.created = LocalDateTime.now();
            this.updated = LocalDateTime.now();
        }
        public Cafeteria toEntity() {
            return Cafeteria.builder()
                    .id(id)
                    .name(name)
                    .created(created)
                    .updated(updated)
                    .build();
        }
    }

    @Getter
    public static class NameList {
        private String name;

        @Builder
        public NameList(String name) {
            this.name = name;
        }
    }

}
