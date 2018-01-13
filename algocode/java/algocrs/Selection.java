import java.util.*;

@SuppressWarnings("unchecked")
public class Selection {
    /*public static void sort(Comparable a[]) {
     *  for (int i = 0; i < a.length; i++) {
     *      int min = i;
     *      for (int j = i + 1; j < a.length; j++) {
     *          if (less(a[j], a[min])) {
     *              min = j;
     *          }
     *      }
     *      swap(a, i, min);
     *  }
     * }*/

    public static void sort(Comparable[] a) { // Sort a[] into increasing order.
        int N = a.length;                     // array length

        for (int i = 0; i < N; i++) {         // Exchange a[i] with smallest entry in a[i+1...N).
            int min = i;                      // index of minimal entr.
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            swap(a, i, min);
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
