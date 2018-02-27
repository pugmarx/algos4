import java.io.PrintStream;

public class LinkedList <K, V> {
    Node <K, V> first;
    Node <K, V> last;
    private int N = 0;

    public void add(Node <K, V> node) {
        if (this.N == 0) {
            this.first = node;
            this.last  = node;
            node.next  = null;
        }
        else {
            Node <K, V> node2 = this.first;
            this.first = node;
            node.next  = node2;
        }
        ++this.N;
    }

    public void add(K k, V v) {
        this.add(new Node <K, V>(k, v));
    }

    public int size() {
        return(this.N);
    }

    public boolean isEmpty() {
        return(this.N == 0);
    }

    public V remove(int n) {
        if (n < 0 || n > this.N - 1) {
            throw new IllegalArgumentException("Invalid index: " + n);
        }
        if (n == 0) {
            return(this.remove());
        }
        Node <K, V> node  = null;
        Node <K, V> node2 = null;
        node  = this.first;
        node2 = this.first.next;
        for (int i = 1; i < this.N; ++i) {
            if (i == n) {
                node.next = node2.next;
                --this.N;
                return(node2.value);
            }
            node  = node2;
            node2 = node2.next;
        }
        return(null);
    }

    public Node <K, V> get(K string) {
        if (this.first.key.equals(string)) {
            return(this.first);
        }
        return(this.get(string, first));
    }

    public Node <K, V> get(K key, Node <K, V> start) {
        Node <K, V> n = start;

        for (; n.next != null; n = n.next) {
            if (key.equals(n.key)) {
                break;
            }
        }
        return(n);
    }

    public void set(K string, V string2) {
        Node <K, V> node = this.get(string);
        node.value = string2;
    }

    public V remove() {
        if (this.N < 1) {
            return(null);
        }
        if (this.N == 1) {
            --N;
            first = null;
            return(null);
        }
        --N;
        Node <K, V> node = this.first;
        this.first = node.next;
        return(node.value);
    }

    public void remove(K string) {
        if (first.key.equals(string)) {
            remove();
            return;
        }
        Node <K, V> node  = null;
        Node <K, V> node2 = null;
        //Object var4_4 = null;
        node2 = this.first;
        node  = this.first.next;
        while (node.next != null&& !node.key.equals(string)) {
            node2 = node;
            node  = node.next;
        }
        node2.next = node.next;
        --this.N;
    }

    public void traverse() {
        Node <K, V> node = this.first;

        while (node != null) {
            System.out.print(String.format("%s |", node));
            node = node.next;
        }
        //System.out.println();
    }

    public String toString() {
        this.traverse();
        return("");
    }

    public static void main(String[] arrstring) throws Exception {
        LinkedList <String, String> linkedList = new LinkedList <>();
    }
}
