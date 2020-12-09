package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        int [] array = {5,10,5,5,10};

        System.out.println("Однопоточный вариант");
        long timeStart1 = System.currentTimeMillis();
        System.out.println("Сумма чисел: "+ sum(array));
        System.out.println("Среднее арифметическое: " + average(array));
        long timeFinish1 = System.currentTimeMillis();
        System.out.println("Прошло мс: " + (timeFinish1 - timeStart1));

        System.out.println("-------------------------------------------------------------");
        System.out.println("Вариант со стримами");
        long timeStart2 = System.currentTimeMillis();
        System.out.println("Сумма чисел: " + Arrays.stream(array).sum());
        System.out.println("Среднее арифметическое: " + Arrays.stream(array).average());
        long timeFinish2 = System.currentTimeMillis();
        System.out.println("Прошло мс: " + (timeFinish2 - timeStart2));

        System.out.println("-------------------------------------------------------------");
        System.out.println("Рекурсивный");
        long timeStart3 = System.currentTimeMillis();
        System.out.println("Сумма чисел: " + SumTask.sumArray(array));
        System.out.println("Среднее арифметическое: " + AverageTask.averageArray(array));
        long timeFinish3 = System.currentTimeMillis();
        System.out.println("Прошло мс: " + (timeFinish3 - timeStart3));

        System.out.println("-------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------");

        Random random = new Random();
        IntStream intStream = random.ints(0, 5_000_000);
        int[] bigArray = intStream.limit(5_000_000).toArray();

        System.out.println("Однопоточный вариант");
        long timeStart4 = System.currentTimeMillis();
        System.out.println("Сумма чисел: "+ sum(bigArray));
        System.out.println("Среднее арифметическое: " + average(bigArray));
        long timeFinish4 = System.currentTimeMillis();
        System.out.println("Прошло мс: " + (timeFinish4 - timeStart4));

        System.out.println("-------------------------------------------------------------");
        System.out.println("Вариант со стримами");
        long timeStart5 = System.currentTimeMillis();
        System.out.println("Сумма чисел: " + Arrays.stream(bigArray).mapToLong(value -> value).sum());
        System.out.println("Среднее арифметическое: " + Arrays.stream(bigArray).mapToLong(value -> value).average());
        long timeFinish5 = System.currentTimeMillis();
        System.out.println("Прошло мс: " + (timeFinish5- timeStart5));

        System.out.println("-------------------------------------------------------------");
        System.out.println("Рекурсивный");
        long timeStart6 = System.currentTimeMillis();
        System.out.println("Сумма чисел: " + SumTask.sumArray(bigArray));
        System.out.println("Среднее арифметическое: " + AverageTask.averageArray(bigArray));
        long timeFinish6 = System.currentTimeMillis();
        System.out.println("Прошло мс: " + (timeFinish6 - timeStart6));
    }

    static long sum(int[] array) {
        long result = 0;
        for (int item : array) {
            result = result + item;
        }
        return result;
    }
    static double average(int[] array) {
        long result = 0;
        for (int item : array) {
            result = result + item;
        }
        return (result / array.length);
    }

}
