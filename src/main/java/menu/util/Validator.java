package menu.util;

import menu.domain.Category;

import java.util.List;

public class Validator {

    public static void validateCoachInput(String input) {
        coachNameIsNull(input);
        List<String> list = Parser.parseStringList(input);
        invalidCoachNumber(list);
        duplicatedCoach(list);
        for (String s : list) {
            invalidCoachName(s);
        }
    }

    public static void validateMenuInput(String input) {
        menuIsNull(input);
        List<String> list = Parser.parseStringList(input);
        for (String s : list) {
            invalidMenu(s);
        }
    }

    private static void coachNameIsNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] 올바른 코치 이름을 입력해 주세요.");
        }
    }

    private static void invalidCoachNumber(List<String> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.");
        }
    }

    private static void duplicatedCoach(List<String> coaches){
        if(coaches.size()!=coaches.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 중복된 코치 이름을 입력했습니다.");
        }
    }

    private static void invalidCoachName(String input) {
        if (input.length() < 2 || input.length() > 4) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 2글자 ~ 4글자여야 합니다.");
        }
    }

    private static void menuIsNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] 올바른 메뉴를 입력해 주세요.");
        }
    }

    private static void invalidMenu(String input) {
        if (input.isBlank()) return;

        if (!Category.hasMenu(input)) {
            throw new IllegalArgumentException("[ERROR] 없는 메뉴를 입력하셨습니다. 다시 입력해 주세요.");
        }
    }
}
