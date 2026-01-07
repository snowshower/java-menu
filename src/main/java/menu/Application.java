package menu;

import menu.controller.MenuController;
import menu.domain.RandomStrategy;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomStrategy randomStrategy = new RandomStrategy();
        MenuService menuService = new MenuService(randomStrategy);
        MenuController menuController = new MenuController(inputView, outputView, menuService);

        menuController.run();
    }
}
