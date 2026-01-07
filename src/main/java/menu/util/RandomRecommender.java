package menu.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomRecommender {
    private static final int START = 1;
    private static final int LAST = 5;

    public static int recommendRandomCategory() {
        return Randoms.pickNumberInRange(START, LAST);
    }

    public static String recommendRandomMenu(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
