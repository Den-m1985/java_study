package task3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class Task3 {

    @Test
    public void test() {
        /*
        Отфильтровать людей старше 18 лет.
        Преобразовать список в строку, содержащую имена людей, разделенные запятой.
        Вывести результат на экран.
        Результат:
        Alice, Charlie,
         */
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 17),
                new Person("Charlie", 30),
                new Person("David", 15)
        );
        String outPut = "Alice, Charlie, ";
        String result = people.stream()
                .filter(person -> person.getAge() > 18)
                .map(person -> person.getName() + ", ")
                .collect(Collectors.joining());

        assertEquals(outPut.length(), result.length());

        assertEquals(outPut, result);

    }
}
