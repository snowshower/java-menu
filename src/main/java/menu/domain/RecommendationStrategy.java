package menu.domain;

import java.util.List;

public interface RecommendationStrategy {
    int getCategoryNumber();
    String getMenuName(List<String> menus);
}
