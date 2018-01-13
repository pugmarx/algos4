/******************************************************************************
*  Compilation:  javac SelectionBars.java
*  Execution:    java SelectionBars n
*  Dependencies: StdDraw.java
*
*  Selection sort n random real numbers between 0 and 1, visualizing
*  the results by ploting bars with heights proportional to the values.
*
*  % java SelectionBars 20
*
******************************************************************************/

public class ShellBarsAnim {
    public static void sort(double[] a) { // Sort a[] into increasing order.
        int N = a.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1;                  // 1, 4, 13, 40, 121, 364, 1093, ...
        }
        while (h >= 1) {                    // h-sort the array.
            for (int i = h; i < N; i++) {   // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    show(a, j, j - h);
                    swap(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

/*
 * public static void sort(double[] a) {
 *    int n = a.length;
 *
 *    for (int i = 0; i < n; i++) {
 *       int min = i;
 *       for (int j = i + 1; j < n; j++) {
 *          if (less(a[j], a[min])) {
 *             min = j;
 *          }
 *       }
 *       show(a, i, min);
 *       exch(a, i, min);
 *    }
 * }
 */
    private static void show(double[] a, int i, int min) {
//        StdDraw.setYscale(-a.length + i + 1, i);
        try{
            Thread.sleep(1000);
        }catch (Exception e) {}
        StdDraw.clear();

        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        for (int k = 0; k < i; k++) {
            StdDraw.line(k, 0, k, a[k] * 0.6);
        }
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int k = i; k < a.length; k++) {
            StdDraw.line(k, 0, k, a[k] * 0.6);
        }
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.line(min, 0, min, a[min] * 0.6);
    }

    private static boolean less(double v, double w) {
        return(v < w);
    }

    private static void swap(double[] a, int i, int j) {
        double t = a[i];

        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        StdDraw.setCanvasSize(160, 640);
        StdDraw.setXscale(-1, n + 1);
        StdDraw.setPenRadius(0.006);
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(0.0, 1.0);
        }
        sort(a);
    }
}
