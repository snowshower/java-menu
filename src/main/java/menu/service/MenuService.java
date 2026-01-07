package menu.service;

import menu.domain.*;

import java.util.Collections;
import java.util.List;

public class MenuService {
    private final RecommendationStrategy randomStrategy;

    public MenuService(RecommendationStrategy randomStrategy) {
        this.randomStrategy = randomStrategy;
    }

    public void recommendMenu(List<String> categories, Coaches coaches) {

        int categoryNum = recommendCategory(categories);
        for (Coach coach : coaches.getCoaches()) {
            while (true) {
                String menu = randomStrategy.getMenuName(Category.from(categoryNum).getMenus());
                if (coach.isBanMenu(menu)) continue;
                if (coach.isEatenMenu(menu)) continue;
                coach.eat(menu);
                break;
            }
        }
    }

    private int recommendCategory(List<String> categories) {

        while (true) {
            int categoryNum = randomStrategy.getCategoryNumber();
            String categoryName = Category.from(categoryNum).getCategoryName();
            int count = Collections.frequency(categories, categoryName);
            if (count > 2) continue;
            categories.add(categoryName);
            return categoryNum;
        }
    }
}
