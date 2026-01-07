package menu.service;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.util.RandomRecommender;

import java.util.List;

public class MenuService {

    public void recommendMenu(List<String> categories, Coaches coaches){

        int categoryNum= RandomRecommender.recommendRandomCategory();
        categories.add(Category.from(categoryNum).getCategoryName());

        for (Coach coach : coaches.getCoaches()) {
            while(true){
                String menu=Category.getRandomMenu(categoryNum);
                if(coach.isBanMenu(menu)) continue;
                if(coach.isEatenMenu(menu)) continue;
                coach.eat(menu); break;
            }
        }
    }
}
