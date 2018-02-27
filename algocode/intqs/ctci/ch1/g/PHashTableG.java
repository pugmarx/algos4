import java.io.PrintStream;
import java.util.*;
import java.lang.reflect.Array;

/**
 * A simple string-based hashtable table that uses an array of linkedlists to store data
 * TODO: Dynamic resizing of original array
 **/

public class PHashTableG <K, V> {
    private static final int LEN = 15;
//    private LinkedList<K,V>[] ll = (LinkedList<K,V>[]) new Object[LEN];
    private LinkedList <K, V>[] ll = (LinkedList <K, V>[])Array.newInstance(LinkedList.class, LEN);
    public void put(K string, V string2) {
        int n = this.getBucket(new Node <K, V>(string, string2));

        if (this.ll[n] == null) {
            this.ll[n] = new LinkedList <K, V>();
        }
        this.ll[n].add(string, string2);
    }

    private int getBucket(Node <K, V> node) {
        int n = node.hashCode();

        return(Math.abs(n % LEN));
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
        }
    }

    public void print() {
        for (int i = 0; i < LEN; ++i) {
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

        p1.put(1, 12345);
        p1.put(2, 222);
        p1.put(23, 455);
        p1.put(4, 5);
        p1.put(233, 45);
        p1.put(5, 2);
        p1.put(32, 45555);

        p1.print();
        p1.remove(4);
        p1.print();
        p1.put(4, 5);
        p1.print();
        System.out.println("get 32 " + p1.get(32));
    }
}
