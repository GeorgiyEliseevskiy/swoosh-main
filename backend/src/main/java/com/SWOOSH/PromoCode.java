package com.SWOOSH;

public class PromoCode {

    public void addPromoToDataBase(String promo) {
        // Добавляем в бд промокод.
    }

    public static String generatePromo(int countOfOrder) {
        double min, max = 0;
        int countPromo = 0;

        String promo = PasswordGenerator.generate();
        promo = promo + "@";

        if (countOfOrder >= 12000) {
            min = 9;
            max = 20;
        }
        else {
            min = 0.1;
            max = 8;
        }

        double countOfDiscount = (Math.random()*((max-min)+1))+min;
        if (countOfDiscount > 0 && countOfDiscount < 4) {
            countPromo = 2;
        }
        else if(countOfDiscount >= 4 && countOfDiscount < 9) {
            countPromo = 5;
        }
        else if(countOfDiscount >= 9 && countOfDiscount < 14) {
            countPromo = 10;
        }
        else if(countOfDiscount >= 14 && countOfDiscount <= 20) {
            countPromo = 15;
        }

        promo = promo + countPromo;

        return promo;
    }
}
