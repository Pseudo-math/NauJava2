import java.util.ArrayList;
import java.util.Random;

public class WorkWithList {
    private static ArrayList<Double> generateRandomList(int count) {
        var array = new ArrayList<Double>(count);
        var random = new Random();
        for (var i = 0; i < count; i++) {
            array.add(random.nextDouble());
        }
        return array;
    }
    public static void bubbleSort(int count) {
        var list = generateRandomList(count);
        System.out.println(list);

        for (var i = 0; i < count - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                var temp = list.get(i);
                list.set(i, list.get(i + 1));
                list.set(i + 1, temp);
            }
        }

        System.out.println(list);
    }
}
