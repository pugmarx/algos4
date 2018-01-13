import java.util.*;

@SuppressWarnings("unchecked")
public class SortTemplate {
    public static void sort(Comparable a[]) {
        /*algo implementation*/
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
