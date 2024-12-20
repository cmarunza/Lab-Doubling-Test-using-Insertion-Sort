import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int initialSize = 1000;
        int iterations = 6;

        System.out.printf("%-10s %-20s %-20s\n", "N", "Selection (ms)", "Insertion (ms)");

        for (int i = 0; i < iterations; i++) {
            int N = initialSize * (int) Math.pow(2, i);
            double[] randomArray = generateRandomArray(N);

            //selection sort and measure time
            double[] selectionArray = Arrays.copyOf(randomArray, randomArray.length);
            long selectionStartTime = System.currentTimeMillis();
            selectionSort(selectionArray);
            long selectionEndTime = System.currentTimeMillis();
            long selectionSortTime = selectionEndTime - selectionStartTime;

            //insertion sort and measure time
            double[] insertionArray = Arrays.copyOf(randomArray, randomArray.length);
            long insertionStartTime = System.currentTimeMillis();
            insertionSort(insertionArray);
            long insertionEndTime = System.currentTimeMillis();
            long insertionSortTime = insertionEndTime - insertionStartTime;


            System.out.printf("%-10d %-20d %-20d\n", N, selectionSortTime, insertionSortTime);
        }
    }

    // Generates an array of N random doubles between 0.0 and 1.0
    public static double[] generateRandomArray(int N) {
        double[] array = new double[N];
        for (int i = 0; i < N; i++) {
            array[i] = StdRandom.uniform(0.0, 1.0);
        }
        return array;
    }

    // Selection Sort
    public static void selectionSort(double[] array) {
        int N = array.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    // Insertion Sort
    public static void insertionSort(double[] array) {
        int N = array.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                swap(array, j, j - 1);
            }
        }
    }

    public static void swap(double[] array, int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

