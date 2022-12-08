package com.SWOOSH;


import com.SWOOSH.repository.PromoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CountDiscount {
    private final PromoRepository promoRepository;

    public static int percentOfDiscount(String promocode) { // Получаем размер скидки
        int percentOfDiscount;
        percentOfDiscount = Integer.parseInt(promocode.split("@")[1]);
        return percentOfDiscount;
    }


    // TODO При завершение услуги мы прибавляем к счетчику сумму заказа,
    //  после завершения передаем в метод генерации промо
}
