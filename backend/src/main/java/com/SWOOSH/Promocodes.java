package com.SWOOSH;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "promocodes")
@Data
@NoArgsConstructor
public class Promocodes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "promo_id", nullable = false)
    private int id;

    @Column(name = "promocode")
    private String promocode;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "status")
    private boolean status;

    public Promocodes(String promocode, int user_id, boolean status) {
        this.promocode = promocode;
        this.user_id = user_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String generatePromo(int countOfOrder) {
        double min, max = 0;
        int countPromo = 0;

        String promo = PasswordGenerator.generate(); // Выглядит так ray0sYk4K2

        promo = promo + "@"; // Скидка указывается в конце после '@'
        // Добавляем на конец сгениророванного промокода "@", чтобы потом добавить размер случайной скидки
        // На данный момент промокод выглядит так: ray0sYk4K2@

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

        promo = promo + countPromo; // добавляем размер скидки в конец промокода. Промо будет выглядеть так: ray0sYk4K2@15

        return promo;
    }
}
