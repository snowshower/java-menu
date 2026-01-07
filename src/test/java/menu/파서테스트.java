package menu;

import menu.util.Parser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 파서테스트 {
    private final List<String> list1=new ArrayList<>(List.of("토미", "제임스", "포코"));
    private final List<String> list2=new ArrayList<>(List.of("우동", "스시"));

    @Test
    void 파서테스트(){
        Assertions.assertThat(Parser.parseStringList("토미,제임스,포코")).isEqualTo(list1);
        Assertions.assertThat(Parser.parseStringList("우동,스시")).isEqualTo(list2);
    }

}
