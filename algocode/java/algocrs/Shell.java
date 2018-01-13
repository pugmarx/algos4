import java.util.*;

@SuppressWarnings("unchecked")
public class Shell {
/*  public static void sort(Comparable a[]) {
 *    int h = 1;
 *    int N = a.length;
 *
 *    while (h < N / 3) {
 *       h = 3 * h + 1;                // 1, 4, 13, 40..
 *    }
 *    while (h >= 1) {
 *       for (int i = 0; i < N; i++) {
 *          for (int j = i; j >= h; j = j - h) {
 *             if (less(a[j], a[j - h])) {
 *                swap(a, j, j - h);
 *             }
 *          }
 *       }
 *       h = h / 3;
 *    }
 * }
 */
    public static void sort(Comparable[] a) { // Sort a[] into increasing order.
        int N = a.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1;                // 1, 4, 13, 40, 121, 364, 1093, ...
        }
        while (h >= 1) {                  // h-sort the array.
            for (int i = h; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return(v.compareTo(w) < 0);
    }

    private static void swap(Comparable[] a, int i, int j) {
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
