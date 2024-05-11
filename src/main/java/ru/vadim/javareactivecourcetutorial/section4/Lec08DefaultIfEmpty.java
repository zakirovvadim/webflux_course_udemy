package ru.vadim.javareactivecourcetutorial.section4;

import reactor.core.publisher.Flux;
import ru.vadim.javareactivecourcetutorial.courceUtil.Util;

import java.time.Duration;

public class Lec08DefaultIfEmpty {
    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i > 10)
                .defaultIfEmpty(-100) // возвращает дефолтное значение если получил пустые данные в потоке, например в фильтре
                // т е если из фильтра вообще ничего не вышло, т е нет чисел больше 100 вообще, тогда выдаст минус 100
                .subscribe(Util.onNext());

    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 10);
    }
}
