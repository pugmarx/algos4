import java.util.*;

/**
 * Given a list of integers, find the highest product you can get from three of the integers
 */

// Find all combinations of 3-pairs and check their product - to find the highest products
// This would of-course have n^3 complexity because of 3 loops over the same array
class Q3Brute {
}

// Sort the array
// Take product of first two numbers & the last no
// Take product of the last 3 nos
// Compare the products, the one which yeilds the hights is the final set of ints.
class Q3Efficient {
    public static void main(String a[]) {
        int[] li = new int[] { -10, -10, 1, 3, 2 };

        for (int i: getListOfHighestProductInts(li)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] getListOfHighestProductInts(int[] li) {
        Arrays.sort(li);
        int prod1 = li[0] * li[1] * li[li.length - 1];
        int N     = li.length;
        int prod2 = li[N - 2] * li[N - 1] * li[N - 3];

        if (prod1 > prod2) {
            return(new int[] { li[0], li[1], li[N - 1] });
        }
        return(new int[] { li[N - 3], li[N - 2], li[N - 1] });
    }
}
