package com.itwill.enum01;

public class EnumTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int meal = Meal.BREAKFAST;

        switch(meal) {
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
