/**
 * Basic QuickFind impl. for Union-Find requirement
 **/
import java.util.Scanner;
public class WeightedQuickUnion implements UnionFind {
    int a[];
    int w[];     //holds the 'weights'
    int count;   // number of individual components

    public WeightedQuickUnion(int size) {
        _init(size);
    }

    public void _init(int N) {
        if (N < 1) {
            throw new IllegalArgumentException("invalid size");
        }
        a          = new int[N];
        w          = new int[N];
        this.count = N;
        for (int i = 0; i < N; i++) {
            a[i] = i;           // default
        }
        for (int i = 0; i < N; i++) {
            w[i] = 1;           // default weight
        }
    }

    // Makes union of p and q by assigning the same root to both
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        if (w[rootP] < w[rootQ]) {
            a[rootP]  = rootQ;
            w[rootQ] += w[rootP];
        }
        else{
            a[rootQ]  = rootP;
            w[rootP] += w[rootQ];
        }

        //a[rootQ] = rootP;
        count--;
    }

    // Returns index of root of p
    public int find(int p) {
        while (a[p] != p) {
            p = a[p];
        }

        return(a[p]);
    }

    public int getCount() {
        return(count);
    }

    public void print() {
        for (int i = 0; i < w.length; i++) {
            System.out.print(w[i] + "|");
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "|");
        }
        System.out.println();
        System.out.println("Count: " + count);
    }

    // Indicates whether p and q are connected
    public boolean connected(int p, int q) {
        if (p > (a.length - 1) || q > (a.length - 1)) {
            return(false);
        }
        int rootP = find(p);
        int rootQ = find(q);
        return(rootP == rootQ);
    }

    public static void main(String s[]) {
        WeightedQuickUnion q  = new WeightedQuickUnion(Integer.valueOf(s[0]));
        Scanner            sc = new Scanner(System.in);

        while (sc.hasNext()) {
            char v = sc.next().toCharArray()[0];

            switch (v) {
            case 'u':
                q.union(sc.nextInt(), sc.nextInt());
                q.print();
                break;

            case 'f':
                System.out.println(q.find(sc.nextInt()));
                break;

            case 'c':
                System.out.println(q.connected(sc.nextInt(), sc.nextInt()));
                break;

            case 'p':
                q.print();
                break;

            case 'q':
            default:
                System.exit(0);
            }
        }
    }
}
