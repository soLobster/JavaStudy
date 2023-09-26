package com.itwill.enum01;

public class EnumTest {

    public static void main(String[] args) {
        Meal03 meal3 = Meal03.DINNER;
        meal3.getOrder();
        //enum은 enum이라는 클래스에서 이미 상속받은 메서드들이 많이 있다....
        System.out.println(meal3.ordinal());
        //= meal3.getOrder();
        
        
        Meal2 meal2 = Meal2.BREAKFAST;
        if(meal2 == Meal2.BREAKFAST) {

        } else if (meal2 == Meal2.LUNCH) {

        } else if (meal2 == Meal2.DINNER) {

        }  else {

        }


        int meal = Meal.BREAKFAST;

        switch(meal) { //사용가능한 switch 타입 int string enum...
        case Meal.BREAKFAST:
            System.out.println("아침");
            break;
        case Meal.LUNCH:
            System.out.println("점심");
            break;
        case Meal.DINNER:
            System.out.println("저녁");
            break;
        default:
        }
    }

}
