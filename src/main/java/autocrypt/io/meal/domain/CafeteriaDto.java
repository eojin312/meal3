package autocrypt.io.meal.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CafeteriaDto {

    private String name;
    private String cuisine;

    @Getter
    public static class Create {
        private int id;
        private String name;
        private String cuisine;

        @Builder
        public Create(int id, String name, String cuisine) {
            this.id = id;
            this.name = name;
            this.cuisine = cuisine;
        }
        public Cafeteria toEntity() {
            return Cafeteria.builder()
                    .id(id)
                    .name(name)
                    .cuisine(cuisine)
                    .build();
        }

    }

    class RandomCafeteria {
        private String name;
    }


}
