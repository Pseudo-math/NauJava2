import java.util.Arrays;
import java.util.Random;

public class WorkWithArray {
    private static int[] generateRandomArray(int count) {
        var array = new int[count];
        var random = new Random();
        for (var i = 0; i < count; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
    public static void averageValue(int count) {
        var array = generateRandomArray(count);
        int sum = 0;
        for (var value : array) {
            sum += value;
        }

        System.out.println(Arrays.toString(array));
        System.out.println((double)sum / count);
    }
}
