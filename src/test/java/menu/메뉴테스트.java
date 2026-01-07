package menu;

import menu.domain.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 메뉴테스트 {

    @Test
    void 메뉴테스트(){
        Assertions.assertThat(Category.from(1)).isEqualTo(Category.JAPANESE);
        Assertions.assertThat(Category.from(4)).isEqualTo(Category.ASIAN);
    }
}
