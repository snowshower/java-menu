package menu.view;

import menu.domain.Coach;
import menu.domain.Coaches;

import java.util.List;

public class OutputView {

    public void outputStart(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void outputMenuResult(List<String> categories, Coaches coaches){
        System.out.println();
        System.out.println("메뉴 추천 결과입니다.\n" +
                "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

        //[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]
        System.out.print("[ 카테고리");
        for (String category : categories) {
            System.out.print(" | "+category);
        }
        System.out.println(" ]");

        //[ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]
        for (Coach coach : coaches.getCoaches()) {
            System.out.print("[ "+coach.getName());
            for (String eatenMenu : coach.getEatenMenu()) {
                System.out.print(" | "+eatenMenu);
            }
            System.out.println(" ]");
        }

        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }
}
