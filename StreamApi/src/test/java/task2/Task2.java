package task2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task2 {

    @Test
    public void test() {
        /*
        Отфильтровать четные числа.
        Умножить каждое оставшееся число на 2.
        Найти среднее значение полученных чисел.
        Вывести результат на экран.
        Результат:
        Среднее значение: 10.0
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        double result = numbers.stream()
                .filter(o -> o % 2 != 0)
                .mapToInt(o -> o * 2)
                .average()
                .orElse(0);

        assertEquals(10.0, result,2);
    }
}
