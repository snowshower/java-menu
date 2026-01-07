package menu;

import menu.domain.Category;
import menu.util.RandomRecommender;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class 랜덤테스트 {

    @Test
    void 랜덤카테고리테스트() {
        int i = RandomRecommender.recommendRandomCategory();
        Assertions.assertThat(Category.from(i)).isBetween(Category.JAPANESE, Category.WESTERN);
    }

    @Test
    void 랜덤메뉴테스트() {
        List<String> menus = Category.JAPANESE.getMenus();
        String s = RandomRecommender.recommendRandomMenu(menus);
        Assertions.assertThat(menus.contains(s)).isTrue();
    }
}
