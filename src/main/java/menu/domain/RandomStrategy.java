package menu.domain;

import menu.util.RandomRecommender;

import java.util.List;

public class RandomStrategy implements RecommendationStrategy {
    @Override
    public int getCategoryNumber() {
        return RandomRecommender.recommendRandomCategory();
    }

    @Override
    public String getMenuName(List<String> menus) {
        return RandomRecommender.recommendRandomMenu(menus);
    }
}
