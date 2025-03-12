package task1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task1 {

    @Test
    public void test() {
         /*
        Отфильтровать имена, которые начинаются с заглавной буквы.
        Преобразовать оставшиеся имена в верхний регистр.
        Отсортировать имена в алфавитном порядке.
        Вывести результат на экран.
        Результат:
        ALICE
        CHARLIE
        EVE
         */
        List<String> names = Arrays.asList("Alice", "bob", "Charlie", "david", "Eve", "frank");
        List<String> outPut = Arrays.asList("ALICE", "CHARLIE", "EVE");
        List<String> result = names.stream()
                .filter(o -> Character.isUpperCase(o.charAt(0)))
                .map(String::toUpperCase)
                .sorted()
                .toList();

        assertEquals(outPut.size(),result.size());
        for (int i = 0; i < outPut.size(); i++) {
            assertEquals(outPut.get(i),result.get(i));
        }
    }
}
