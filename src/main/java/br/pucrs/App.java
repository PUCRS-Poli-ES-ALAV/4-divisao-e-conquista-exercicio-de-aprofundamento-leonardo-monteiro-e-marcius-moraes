package br.pucrs;

/**
 * Hello world!
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    
        public static List<Integer> mergeSort(List<Integer> L) {
            if (L.size() <= 1) {
                return L;
            }
    
            int mid = L.size() / 2;
            List<Integer> left = L.subList(0, mid);
            List<Integer> right = L.subList(mid, L.size());
    
            left = mergeSort(left);
            right = mergeSort(right);
    
            return merge(left, right);
        }
    
        public static List<Integer> merge(List<Integer> left, List<Integer> right) {
            List<Integer> result = new ArrayList<>();
            int i = 0, j = 0;
    
            while (i < left.size() && j < right.size()) {
                if (left.get(i) <= right.get(j)) {
                    result.add(left.get(i));
                    i++;
                } else {
                    result.add(right.get(j));
                    j++;
                }
            }
    
            while (i < left.size()) {
                result.add(left.get(i));
                i++;
            }
    
            while (j < right.size()) {
                result.add(right.get(j));
                j++;
            }
    
            return result;
        }
    
        public static long maxVal1(long[] A, int n) {
            long max = A[0];
            for (int i = 1; i < n; i++) {
                if (A[i] > max) {
                    max = A[i];
                }
            }
            return max;
        }
    
        public static long maxVal2(long[] A, int init, int end) {
            if (end - init <= 1) {
                return Math.max(A[init], A[end]);
            } else {
                int m = (init + end) / 2;
                long v1 = maxVal2(A, init, m);
                long v2 = maxVal2(A, m + 1, end);
                return Math.max(v1, v2);
            }
        }
    
        public static long multiply(long x, long y, int n) {
            if (n == 1) {
                return x * y;
            } else {
                int m = (int) Math.ceil(n / 2.0);
    
                long a = x / (long) Math.pow(2, m);
                long b = x % (long) Math.pow(2, m);
                long c = y / (long) Math.pow(2, m);
                long d = y % (long) Math.pow(2, m);
    
                long e = multiply(a, c, m);
                long f = multiply(b, d, m);
                long g = multiply(b, c, m);
                long h = multiply(a, d, m);
    
                return (long) Math.pow(2, 2 * m) * e + (long) Math.pow(2, m) * (g + h) + f;
            }
        }
    
        public static List<Integer> generateRandomList(int size) {
            Random random = new Random();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(random.nextInt(10000));
            }
            return list;
        }
    
        public static long[] generateRandomArray(int size) {
            Random random = new Random();
            long[] array = new long[size];
            for (int i = 0; i < size; i++) {
                array[i] = random.nextLong();
            }
            return array;
        }
    
        public static void testMergeSort(int size) {
            System.out.println("\n### Teste Merge Sort ###");
            List<Integer> list = generateRandomList(size);
            long startTime = System.nanoTime();
            List<Integer> sortedList = mergeSort(list);
            long endTime = System.nanoTime();
            double duration = (endTime - startTime) / 1_000_000.0;
    
            System.out.printf("Tamanho da Lista: %-10d Tempo: %-10.4f ms Resultado: %-20s\n", size, duration, sortedList.size());
        }
    
        public static void testMaxVal1(int size) {
            System.out.println("\n### Teste Max Value Iterativo ###");
            long[] array = generateRandomArray(size);
            long startTime = System.nanoTime();
            long maxVal = maxVal1(array, size);
            long endTime = System.nanoTime();
            double duration = (endTime - startTime) / 1_000_000.0;
    
            System.out.printf("Tamanho do Array: %-10d Tempo: %-10.4f ms Max Value: %-20d\n", size, duration, maxVal);
        }
    
        public static void testMaxVal2(int size) {
            System.out.println("\n### Teste Max Value Divisão e Conquista ###");
            long[] array = generateRandomArray(size);
            long startTime = System.nanoTime();
            long maxVal = maxVal2(array, 0, size - 1);
            long endTime = System.nanoTime();
            double duration = (endTime - startTime) / 1_000_000.0;
    
            System.out.printf("Tamanho do Array: %-10d Tempo: %-10.4f ms Max Value: %-20d\n", size, duration, maxVal);
        }
    
        public static void testMultiply(int size) {
            System.out.println("\n### Teste Multiplicação Inteira ###");
            long x = (long) (Math.random() * Math.pow(2, size));
            long y = (long) (Math.random() * Math.pow(2, size));
            long startTime = System.nanoTime();
            long product = multiply(x, y, size);
            long endTime = System.nanoTime();
            double duration = (endTime - startTime) / 1_000_000.0;
    
            System.out.printf("Tamanho (bits): %-10d Tempo: %-10.4f ms Resultado: %-20d\n", size, duration, product);
        }
    
        public static void main(String[] args) {
            testMergeSort(32);
            testMaxVal1(32);
            testMaxVal2(32);
            testMultiply(16);
        }
    }
}    