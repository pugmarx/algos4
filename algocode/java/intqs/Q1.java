import java.util.*;


/**
 *      Find most profitable buy/sell price.
 */

// Not very brute approach -- but still O(n^2) :(
class Q1Brute {
    public static void main(String a[]) throws Exception {
        int[] stockPricesYesterday = new int[] { 10, 7, 5, 8, 11, 9 };

        getMaxProfit(stockPricesYesterday);
    }

    private static int getMaxProfit(int[] stockPrices) {
        int    maxVal    = 0;
        String maxValStr = "";

        for (int i = 0; i < stockPrices.length; i++) {
            int buyVal = stockPrices[i];

            for (int j = i + 1; j < stockPrices.length; j++) {
                int sellVal = stockPrices[j];

                if ((sellVal > buyVal) && (sellVal - buyVal > maxVal)) {
                    maxValStr = String.format("%s->%s", buyVal, sellVal);
                    maxVal    = sellVal - buyVal;
                }
            }    //inner loop ends
        }        // outer loop ends

        System.out.println(maxValStr);
        System.out.println(maxVal);

        return(maxVal);
    }
}

/*Smart Approach -- O(N) */

/**
 * The max profit we can get by selling at the currentPrice is simply the difference between the currentPrice and the minPrice from earlier in the day. If this difference is greater than the current maxProfit, we have a new maxProfit.
 *
 * So for every price, we’ll need to:
 *
 * keep track of the lowest price we’ve seen so far
 * see if we can get a better profit
 *
 **/
class Q1SinglePass {
    public static void main(String a[]) throws Exception {
        int[] stockPricesYesterday = new int[] { 10, 7, 5, 8, 11, 9 };

        getMaxProfit(stockPricesYesterday);
    }

    public static int getMaxProfit(int[] stockP) {
        int minSoFar  = stockP[0];
        int maxProfit = 0;

        for (int i = 1; i < stockP.length; i++) {
            int currPrice = stockP[i];

            if (currPrice < minSoFar) {
                minSoFar = currPrice;
            }

            if ((currPrice - minSoFar) > maxProfit) {
                maxProfit = currPrice - minSoFar;
            }
        }        // end for

        System.out.println(maxProfit);
        return(maxProfit);
    }
}
