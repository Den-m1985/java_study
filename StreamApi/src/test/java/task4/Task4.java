package task4;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Task4 {

    @Test
    public void test() {
        /*
        Подсчитать количество вхождений каждого числа.
        Найти число, которое встречается чаще всего.
        Вывести это число и количество его вхождений на экран.
        Результат:
        Среднее значение: 4
         */
        int[] numbers = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5};

        Map<Integer, Long> frequenceMap = Arrays.stream(numbers)
                .boxed()  // Преобразуем int в Integer для использования в Stream API
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));  // Подсчитываем количество вхождений каждого числа

        Map.Entry<Integer, Long> mostFrequent = frequenceMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        Integer expect = 4;
        assertNotNull(mostFrequent.getValue());
        assertNotNull(mostFrequent.getKey());
        assertEquals(expect, mostFrequent.getKey());
    }
}
