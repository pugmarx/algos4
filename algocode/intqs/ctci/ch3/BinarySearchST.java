import java.util.Scanner;

/**
 *      Binary Search ST from Sedgewick et. al.
 * TODO: Implement keys(), min(), max(), floor(), ceiling()
 **/

public class BinarySearchST <Key extends Comparable <Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[])new Comparable[capacity];
        vals = (Value[])new Object[capacity];
    }

    public Value get(Key key) {
        if (N == 0) {
            return(null);
        }
        int index = rank(key);

        if (index < N && keys[index].compareTo(key) == 0) {
            return(vals[index]);
        }

        return(null);
    }

    public void put(Key key, Value val) {
        int index = rank(key);

        // update if already exists
        if (keys[index] == null) {
            keys[index] = key;
            vals[index] = val;
//			N++;
//			return;
        }
        else{
            if (index < N && keys[index].compareTo(key) == 0) { //key already present
                vals[index] = val;                              // update the value!
                return;
            }

            // create space for this new key
            for (int j = N; j > index; j--) {
                keys[j] = keys[j - 1];
                vals[j] = vals[j - 1];
            }
            keys[index] = key;
            vals[index] = val;

//			N++;
        }
        N++;
    }

    // iterative rank impl.
    public int rank(Key key) {
        int lo = 0;
        int hi = N - 1;       // size = 3 => 0..2

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            //System.out.println(lo + "::" + hi+ "::"+mid);

            int cmp = key.compareTo(keys[mid]);

            if (cmp == 0) {
                return(mid);
            }
            if (cmp < 0) {           // search left half
                hi = mid - 1;
            }
            else if (cmp > 0) {                         // search right half
                lo = mid + 1;
            }
            else{
                return(mid);
            }
        }
        return(lo);        // !!
    }

/**
 *      public Iterable<Key> keys(){
 *              return keys;
 *      }
 *
 *      private Iterable<Key> keys(Key from, Key to){
 *              int findex = rank(from);
 *              int tindex = rank(to);
 *
 *              Key[] itKeys = Arrays.copyOf(keys, findex, tindex);
 *              return itKeys;
 *      }
 */

    // recursive rank impl.
    public int rankr(Key key) {
        return(rankr(key, 0, N - 1));
    }

    // retursive rank impl.
    private int rankr(Key key, int lo, int hi) {
        if (hi < lo) {
            return(lo);
        }
        int mid = lo + (hi - lo) / 2;
        int cmp = keys[mid].compareTo(key);

        if (cmp == 0) {
            return(mid);
        }

        if (cmp > 0) {       // look in left-half
            return(rankr(key, lo, mid - 1));
        }
        else{                   // look in right-half
            return(rankr(key, mid + 1, hi));
        }
    }

    public void print() {
        for (int i = 0; i < N; i++) {
            System.out.print(keys[i] + "|\t");
        }

        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.print(vals[i] + "|\t");
        }
        System.out.println();
    }

    public void delete(Key key) {
    }

    public static void main(String a[]) {
        BinarySearchST <String, Integer> bsst = new BinarySearchST <>(100);
//		bsst.put("S", 1);
//		bsst.put("E", 2);
//		bsst.put("A", 3);
//		bsst.put("R", 4);
//		bsst.put("C", 5);
//		bsst.put("H", 6);
//		bsst.put("E", 7);

/**		bsst.put("X", 8);
 *              bsst.put("A", 9);
 *              bsst.put("M", 10);
 *              bsst.put("P", 11);
 */
        Scanner sc = new Scanner(System.in);
        while (true) {
            bsst.put(sc.next(), sc.nextInt());
            bsst.print();
        }
    }
}
