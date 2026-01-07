package menu.service;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.util.RandomRecommender;

import java.util.Collections;
import java.util.List;

public class MenuService {

    public void recommendMenu(List<String> categories, Coaches coaches){

        int categoryNum=recommendCategory(categories);
        for (Coach coach : coaches.getCoaches()) {
            while(true){
                String menu=Category.getRandomMenu(categoryNum);
                if(coach.isBanMenu(menu)) continue;
                if(coach.isEatenMenu(menu)) continue;
                coach.eat(menu); break;
            }
        }
    }

    private int recommendCategory(List<String> categories){

        while(true){
            int categoryNum= RandomRecommender.recommendRandomCategory();
            String categoryName=Category.from(categoryNum).getCategoryName();
            int count= Collections.frequency(categories, categoryName);
            if(count>2) continue;
            categories.add(categoryName);
            return categoryNum;
        }
    }
}
