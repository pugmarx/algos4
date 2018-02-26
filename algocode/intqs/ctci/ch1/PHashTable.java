/*
 * Decompiled with CFR 0_125.
 */
import java.io.PrintStream;
import java.util.*;

public class PHashTable {
    private static final int LEN = 15;
    private LinkedList[] ll = new LinkedList[15];

    public void put(String string, String string2) {
        int n = this.getBucket(new Node(string, string2));
        if (this.ll[n] == null) {
            this.ll[n] = new LinkedList();
        }
        this.ll[n].add(string, string2);
    }

    private int getBucket(Node node) {
        int n = node.hashCode();
        return Math.abs(n % LEN);
    }

    public String get(String key) {
        int n = getBucket(new Node(key, null));
        return ll[n].get(key).value;
    }

	public void remove(String key){
		int b = getBucket(new Node(key, null));
		ll[b].remove(key);
	}

    public void print() {
        for (int i = 0; i < LEN; ++i) {
            System.out.println(this.ll[i]);
        }
		System.out.println();
    }

    public static void main(String[] arrstring) {
        PHashTable p = new PHashTable();
        p.put("aa", "first");
        p.put("ab", "second");
        p.put("abc", "third");
        p.put("ax", "fourth");
        p.put("aj", "12345");
		p.put("ba", "adaa");
		p.put("ca", "casaf");
        p.put("at", "fourth");
        p.put("av", "12345");
		p.put("bb", "adaa");
		p.put("cv", "casaf");
        p.put("xa", "12345");
		p.put("br", "adaa");
		p.put("cd", "casaf");
        p.put("ak", "fourth");
        p.put("dv", "12345");
		p.put("bab", "adaa");
		p.put("cvs", "casaf");
			
        p.print();
		p.remove("dv");
		p.print();
		System.out.println("get abc " + p.get("abc"));

    }
}
