package menu.controller;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.service.MenuService;
import menu.util.Parser;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;

    public MenuController(InputView inputView, OutputView outputView, MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;
    }

    public void run() {
        outputView.outputStart();

        List<String> coachNames = Parser.parseStringList(inputView.inputCoachName());
        List<Coach> coachList = new ArrayList<>();

        for (String coachName : coachNames) {
            Coach coach = new Coach(coachName, Parser.parseStringList(inputView.inputBanMenu(coachName)));
            coachList.add(coach);
        }

        Coaches coaches = new Coaches(coachList);
        List<String> categories = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            menuService.recommendMenu(categories, coaches);
        }

        outputView.outputMenuResult(categories, coaches);
    }
}
