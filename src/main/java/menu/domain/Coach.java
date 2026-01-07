package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> banMenu;
    private List<String> eatenMenu;

    public Coach(String name, List<String> banMenu){
        this.name=name;
        this.banMenu=banMenu;
        this.eatenMenu=new ArrayList<>();
    }

    //못 먹는 메뉴면 true
    public boolean isBanMenu(String menu){
        return banMenu.contains(menu);
    }

    //이미 먹은 메뉴면 true
    public boolean isEatenMenu(String menu){
        return eatenMenu.contains(menu);
    }

    public void eat(String menu){
        eatenMenu.add(menu);
    }

    public String getName(){
        return name;
    }

    public List<String> getBanMenu(){
        return banMenu;
    }

    public List<String> getEatenMenu(){
        return eatenMenu;
    }
}
