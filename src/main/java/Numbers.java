import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Numbers {
    static List<Integer> list;

    public Numbers() {

    }

    /**
     * \Метод для генерации чисел
     * @return возвращает лист случайных сгенерированных чисел по заданным параметрам
     */
    public static List<Integer> generateNumbers() {
        List<Integer> list = Stream.generate(() -> ThreadLocalRandom.current().nextInt(1000000))
                .limit(1000)
                .toList();
        return list;
    }

    /**
     * Метод поиска максимального числа в списке случайных чисел
     * @param list принимает на вход список случайно сгенерированных чисел
     * @return максимальное число в списке
     */
    public static Integer findMax(List<Integer> list) {
        Integer max = list.stream().max(Math::max).get();
        return max;
    }

    /**
     * Метод находжения свммц чисел, отвечающих определенным условиям
     * @param list принимает на вход список случайно сгенерированных чисел
     * @return int сумму чисел
     */
    public static Integer sumOfNumbers(List<Integer> list) {
        Integer res = list.stream()
                .filter(it -> it > 500000)
                .map(it -> it * 5 - 150)
                .reduce((x,y) -> x+y)
                .get();
        return res;
    }

    /**
     * Метод для нахождени количества чисел из списка случайно сгенерированных, по определнным условиям
     * (квадрат числа < 100000)
     * @param list принимает на вход список случайно сгенерированных чисел
     * @return размерность полученного списка с числами
     */
    public static int findNumbers(List<Integer> list) {
        List<Integer> res = new ArrayList<Integer>();
        List<Integer> finalRes = res;
        res = list.stream()
                .filter(it -> it * it < 100000)
                .collect(Collectors.toCollection(() -> finalRes));
        return res.size();
    }
}
