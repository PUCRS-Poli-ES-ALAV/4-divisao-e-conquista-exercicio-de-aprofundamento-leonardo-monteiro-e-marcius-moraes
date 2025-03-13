package br.pucrs;

/**
 * Hello world!
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    // Exercicio 1: Merge Sort
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

    // Exercicio 2: Max Value Iterativo
    public static long maxVal1(long[] A, int n) {
        long max = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

    // Exercicio 3: Max Value Divisão e Conquista
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

    // Exercicio 4: Multiplicação Inteira de n-bits
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

    // Método para gerar lista de inteiros aleatórios
    public static List<Integer> generateRandomList(int size) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(10000)); // Valores aleatórios entre 0 e 9999
        }
        return list;
    }

    // Método para gerar vetor de longos aleatórios
    public static long[] generateRandomArray(int size) {
        Random random = new Random();
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextLong();
        }
        return array;
    }

    // Função para executar todos os testes
    public static void runTests() {
        // Tamanhos dos vetores
        int[] sizes = {32, 2048, 1048576};

        // Exemplo de tabela
        System.out.printf("%-30s%-20s%-20s%-20s%-20s\n", "Algoritmo", "Tamanho do Vetor", "Iterações", "Tempo de Execução (ms)", "Resultado");

        // Teste para Merge Sort
        for (int size : sizes) {
            List<Integer> list = generateRandomList(size);
            long startTime = System.nanoTime();
            List<Integer> sortedList = mergeSort(list);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // Tempo em milissegundos

            System.out.printf("%-30s%-20d%-20d%-20d%-20s\n", "Merge Sort", size, 0, duration, sortedList.toString());
        }

        // Teste para Max Value Iterativo
        for (int size : sizes) {
            long[] array = generateRandomArray(size);
            long startTime = System.nanoTime();
            long maxVal = maxVal1(array, size);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // Tempo em milissegundos

            System.out.printf("%-30s%-20d%-20d%-20d%-20d\n", "Max Value Iterativo", size, size - 1, duration, maxVal);
        }

        // Teste para Max Value Divisão e Conquista
        for (int size : sizes) {
            long[] array = generateRandomArray(size);
            long startTime = System.nanoTime();
            long maxVal = maxVal2(array, 0, size - 1);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // Tempo em milissegundos

            System.out.printf("%-30s%-20d%-20d%-20d%-20d\n", "Max Value Divisão e Conquista", size, size - 1, duration, maxVal);
        }

        // Teste para Multiplicação Inteira de n-bits
        for (int size : new int[]{4, 16, 64}) {
            long x = (long) (Math.random() * Math.pow(2, size));
            long y = (long) (Math.random() * Math.pow(2, size));
            long startTime = System.nanoTime();
            long product = multiply(x, y, size);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // Tempo em milissegundos

            System.out.printf("%-30s%-20d%-20d%-20d%-20d\n", "Multiplicação Inteira", size, 0, duration, product);
        }
    }

    // Função main para rodar os testes
    public static void main(String[] args) {
        runTests(); // Chama o método para rodar todos os testes
    }
}
