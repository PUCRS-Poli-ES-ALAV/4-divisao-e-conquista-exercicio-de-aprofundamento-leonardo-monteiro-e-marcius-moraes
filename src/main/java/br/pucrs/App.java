package br.pucrs;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        //Exercicio 1
        public List<Integer> mergeSort(List<Integer> L) {
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
        
        public List<Integer> merge(List<Integer> left, List<Integer> right) {
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
    }


    //Exercicio 2
    public long maxVal1(long[] A, int n) {
        long max = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }
    
    //Exercicio 3
    public long maxVal2(long[] A, int init, int end) {
        if (end - init <= 1) {
            return Math.max(A[init], A[end]);
        } else {
            int m = (init + end) / 2;
            long v1 = maxVal2(A, init, m);
            long v2 = maxVal2(A, m + 1, end);
            return Math.max(v1, v2);
        }
    }
    
    //Exercicio 4
    public long multiply(long x, long y, int n) {
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
    

    //Exercicio 5
}
