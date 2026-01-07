package menu;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.service.MenuService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 서비스테스트 {
    private final MenuService menuService = new MenuService();
    private final List<String> ban1 = new ArrayList<>(List.of("우동", "스시"));
    private final List<String> ban2 = new ArrayList<>(List.of("뇨끼", "월남쌈"));
    private final Coach coach1 = new Coach("포비", ban1);
    private final Coach coach2 = new Coach("초코", ban2);
    private final Coaches coaches = new Coaches(List.of(coach1, coach2));

    @Test
    void 서비스테스트() {
        List<String> categories = new ArrayList<>();
        menuService.recommendMenu(categories, coaches);

        System.out.println(categories);
        for (Coach coach : coaches.getCoaches()) {
            System.out.println(coach.getName() + " : " + coach.getEatenMenu());
        }
    }
}
