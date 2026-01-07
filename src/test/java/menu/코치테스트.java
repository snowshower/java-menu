package menu;

import menu.domain.Coach;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 코치테스트 {
    private final List<String> ban1 = new ArrayList<>(List.of("우동", "스시"));
    private final List<String> ban2 = new ArrayList<>(List.of("뇨끼", "월남쌈"));
    private final Coach coach1 = new Coach("포비", ban1);
    private final Coach coach2 = new Coach("초코", ban2);

    @Test
    void 못먹는메뉴확인테스트() {
        Assertions.assertThat(coach1.isBanMenu("우동")).isTrue();
        Assertions.assertThat(coach2.isBanMenu("우동")).isFalse();
    }

    @Test
    void 먹은메뉴확인테스트() {
        coach1.eat("뇨끼");
        Assertions.assertThat(coach1.isEatenMenu("뇨끼")).isTrue();
    }

    @Test
    void 먹은메뉴추가테스트() {
        coach1.eat("월남쌈");
        Assertions.assertThat(coach1.getEatenMenu().contains("월남쌈")).isTrue();
    }
}
