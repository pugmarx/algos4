/**
 * Basic QuickFind impl. for Union-Find requirement
 **/
import java.util.Scanner;
public class QuickFind implements UnionFind {
    int a[];
    int count;     // number of individual components

    public QuickFind(int size) {
        _init(size);
    }

    public void _init(int N) {
        if (N < 1) {
            throw new IllegalArgumentException("invalid size");
        }
        a          = new int[N];
        this.count = N;
        for (int i = 0; i < N; i++) {
            a[i] = i;           // default
        }
    }

    // Makes union of p and q
    public void union(int p, int q) {
        int valP = find(p);
        int valQ = find(q);

        if (valP == valQ) {
            return;                      // nothing to be done
        }
        //a[q] = valP;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == valQ) {
                a[i] = valP;
            }
        }
        count--;
    }

    // Returns index of p
    public int find(int p) {
        return(a[p]);
    }

    public int getCount() {
        return(count);
    }

    public void print() {
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
        int i = find(p);
        int j = find(q);
        return(a[i] == a[j]);
    }

    public static void main(String s[]) {
        QuickFind q  = new QuickFind(Integer.valueOf(s[0]));
        Scanner   sc = new Scanner(System.in);

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
