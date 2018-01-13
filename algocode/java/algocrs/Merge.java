import java.util.*;

@SuppressWarnings("unchecked")
public class Merge {
    private static Comparable[] aux;

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void sort(Comparable a[]) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        // Copy over to the original array
        for (int k = lo, i = lo, j = mid + 1; k <= hi; k++) {
            if (i > mid) {           // p has crossed over to q's territory
                a[k] = aux[j++];
            }
            else if (j > hi) {            // more than array size, don't increment it anymore
                a[k] = aux[i++];
            }
            else{
                if (less(aux[i], aux[j])) {
                    a[k] = aux[i++];
                }
                else{
                    a[k] = aux[j++];
                }
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return(v.compareTo(w) < 0);
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];

        a[i] = a[j];
        a[j] = tmp;
    }

    private static void print(Comparable[] a) {
        for (Comparable c: a) {
            System.out.print(c + "| ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return(false);
            }
        }
        return(true);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String[] a = sc.nextLine().split("\\s");
            sort(a);
            assert isSorted(a);
            print(a);
        }
    }
}
