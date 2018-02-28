import java.io.PrintStream;
import java.util.*;
import java.lang.reflect.Array;

/**
 * A simple string-based hashtable table that uses an array of linkedlists to store data
 *      TODO: Make it generic						*** Done
 * TODO: Dynamic resizing of original array		*** Done
 *      FIXME LLs are always adding to the head
 *      FIXME Existing keys should be replced if passed again
 **/

public class PHashTableG <K, V> {
    private static int cap = 15;
    private static int sz;
    private static final double LOAD_FACTOR = 0.75;
    private LinkedList <K, V>[] ll          = (LinkedList <K, V>[])Array.newInstance(LinkedList.class, cap);


    public void put(K key, V value) {
        modifyCapacityIfNeeded();
        int n = this.getBucket(new Node <K, V>(key, value));

        if (this.ll[n] == null) {
            this.ll[n] = new LinkedList <K, V>();
            sz++;
        }

        this.ll[n].add(key, value);
    }

    private void modifyCapacityIfNeeded() {
        int threshold = new Double(cap * LOAD_FACTOR).intValue();

        if (sz >= threshold) {
            LinkedList <K, V>[] tmp = (LinkedList <K, V>[])Array.newInstance(LinkedList.class, cap);
            tmp     = Arrays.copyOf(ll, ll.length);
            cap     = 2 * cap;
            this.ll = (LinkedList <K, V>[])Array.newInstance(LinkedList.class, cap);
            //this.ll = Arrays.copyOf(tmp, tmp.length);
            System.arraycopy(tmp, 0, ll, 0, tmp.length);
            //print();
        }
    }

    private int getBucket(Node <K, V> node) {
        int n = node.hashCode();

        return(Math.abs(n % cap));
    }

    public V get(K key) {
        int n = getBucket(new Node <K, V>(key, null));

        return(ll[n].get(key).value);
    }

    public void remove(K key) {
        int b = getBucket(new Node <K, V>(key, null));

        ll[b].remove(key);
        if (ll[b].size() == 0) {
            ll[b] = null;
            sz--;
        }
    }

    public void print() {
        for (int i = 0; i < cap; ++i) {
            System.out.println(this.ll[i]);
        }
        System.out.println();
    }

    public static void main(String[] arrstring) {
/*        PHashTableG<String,String> p = new PHashTableG<String, String>();
 *
 *      p.put("aa", "first");
 *      p.put("ab", "second");
 *      p.put("abc", "third");
 *      p.put("ax", "fourth");
 *      p.put("aj", "12345");
 *      p.put("ba", "adaa");
 *      p.put("ca", "casaf");
 *      p.put("at", "fourth");
 *      p.put("av", "12345");
 *      p.put("bb", "adaa");
 *      p.put("cv", "casaf");
 *      p.put("xa", "12345");
 *      p.put("br", "adaa");
 *      p.put("cd", "casaf");
 *      p.put("ak", "fourth");
 *      p.put("dv", "12345");
 *      p.put("bab", "adaa");
 *      p.put("cvs", "casaf");
 *
 *      p.print();
 *      p.remove("aa");
 *      p.print();
 *      System.out.println("get abc " + p.get("abc"));
 */
        PHashTableG <Integer, Integer> p1 = new PHashTableG <>();

        p1.put(0, 445);
        p1.put(1, 12345);
        p1.put(2, 222);
        p1.put(3, 455);
        p1.put(4, 5);
        p1.put(5, 45);
        p1.put(6, 2);
        p1.put(7, 45555);
        p1.put(8, 45);
        p1.put(9, 2);
        p1.put(11, 45555);
        p1.put(22, 5555);
        p1.put(33, 65555);
        p1.put(44, 4555);
        p1.put(55, 453555);
        p1.put(66, 45455);
        p1.put(77, 555);
        p1.put(90, 4655);
        p1.put(88, 45655);

        p1.put(6, 11111);
//	    p1.print();
//        p1.remove(4);
//		p1.remove(23);
//        p1.print();
//        p1.put(4, 5);
        p1.print();
        System.out.println("get 32 " + p1.get(32));
    }
}
