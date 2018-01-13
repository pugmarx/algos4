import java.util.*;

/**
 *      Singly-linked-list
 *      n -> n+1 ---> n+k
 **/

class Node <Item> {
    Item item;
    Node next;
    public Node() {
    }

    public Node(Item item) {
        this.item = item;
    }
}

@SuppressWarnings("unchecked")
public class LinkedList <Item> {
    Node first;
    Node last;
    private int N = 0;

    // FIXME - unoptimized. space req = 2*N (size of the LL)
    public Node reverseExp() {
        Node reverse = null;
        int  i       = 0;

        for (Node n = first; n != null; n = n.next) {
            if (i == 0) {
                reverse      = new Node(n.item);
                reverse.next = null;
                i++;
            }
            Node r = new Node(n.item);
            Node t = reverse;
            reverse = r;
            r.next  = t;
        }
        return(reverse);
    }

    public Node reverse() {
        return(reverse(first));
    }

    /**
     * Optimized - Destructive implementation for reversing the list
     * From the algo book:
     *  We maintain the invariant that first is the first node of what’s left of the original
     * list, second is the second node of what’s left of the original list, and reverse is the first
     * node of the resulting reversed list.
     **/
    public static Node reverse(Node h) {
        Node first   = h;
        Node reverse = null;
        Node second  = null;

        for (first = h; first != null; first = second) {
            second     = first.next;
            first.next = reverse;
            reverse    = first;
        }
        return(reverse);
    }

    public void add(Item item) {
        Node <Item> node = new Node <>();

        node.item = item;
        if (N == 0) {
            first     = node;
            last      = node;
            node.next = null;
        }
        else{
            Node oldFirst = first;
            first     = node;
            node.next = oldFirst;
        }
        N++;
    }

    public void add(Item item, int index) {
        if (index < 0 || index > N) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }

        if (index == 0) {
            add(item);
            return;
        }

        Node prev = null;
        Node curr = null;
        int  i    = 1;
        for (prev = first, curr = first.next; curr != null; i++) {
            if (i == index) {
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        Node n = new Node(item);
        if (curr == null) {       // end
            n.next    = null;
            prev.next = n;
        }
        else{
            prev.next = n;
            n.next    = curr;
        }
        N++;
    }

    public int size() {
        return(N);
    }

    /**
     * Finds the middle element in the case of Odd number of elements, and second middle element in
     * the case of Even number of elements. Uses 2 pointers to achieve the same, second one (fast ptr)
     * is two elements ahead of the first one (slow ptr).
     **/
    public Node findMid() {
        if (N == 1) {
            return(first);
        }

        Node n, m;
        for (n = first, m = first; m != null&& m.next != null; n = n.next) {
            m = n.next.next;
        }

        // System.out.println(String.format("Mid: %s ", n.item));
        return(n);
    }

    /**
     * Checks if the passed list has a loop. This is done by maintaining a list of all viisted nodes.
     * If a visited node is found in the set, this implies that it has already been visited, and hence
     * there'd be a cycle!!
     **/
    public static boolean hasLoop(Node head) {
        Set <Node> nodes = new HashSet <>();
        for (Node n = head; n != null; n = n.next) {
            if (nodes.contains(n)) {
                return(true);
            }

            nodes.add(n);
        }
        return(false);
    }

    /**
     *      Finds the max within the list (assuming all positive integers)
     **/
    public int max() {
        if (N == 0) {
            return(-1);
        }
        try{
            Integer.valueOf((int)first.item);
        }catch (Exception e) {
            throw new UnsupportedOperationException("unsuppored operation: max");
        }
        int max = -1;
        for (Node n = first; n != null; n = n.next) {
            //System.out.print(String.format("| %s ", n.item));
            if ((int)n.item > max) {
                max = (int)n.item;
            }
        }
        return(max);
    }

    //int max = 0;
    public int checkMax(Node n, int maxSoFar) {
        if (n == null) {
            if ((int)n.item > maxSoFar) {
                maxSoFar = (int)n.item;
            }
            checkMax(n.next, maxSoFar);
        }
        return(maxSoFar);
    }

    public int maxR() {
        return(checkMax(first, 0));
    }

    public boolean hasLoop() {
        if (N == 1) {
            return(false);
        }
        return(hasLoop(first));
    }

    public boolean isEmpty() {
        return(N == 0);
    }

    public Item remove(int index) {
        if (index < 0 || index > (N - 1)) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
        if (index == 0) {
            return(remove());
        }
        int  i    = 1;
        Node prev = null;
        Node curr = null;
        for (prev = first, curr = first.next; i < N; i++) {
            //System.out.print(i + " ");
            if (i == index) {
                prev.next = curr.next;
                //n.next = curr;
                N--;
                return((Item)(curr.item));
                //break;
            }
            prev = curr;
            curr = curr.next;
        }
        return(null);
    }

    public Item remove() {
        if (N < 1) {
            return(null);
        }
        if (N == 1) {
            N--;
            Node temp = first;
            first = null;
            return((Item)(temp.item));
        }
        else{
            N--;
            Node oldFirst = first;
            first = oldFirst.next;
            return((Item)(oldFirst.item));
        }
    }

    public void remove(Item item) {
        if (first.item.equals(item)) {
            remove();
            return;
        }
        Node curr     = null;
        Node prev     = null;
        Node toRemove = null;
        for (prev = first, curr = first.next; curr.next != null;) {
            //System.out.print(String.format("%s ",n.item));
            if (curr.item.equals(item)) {
                //		toRemove = curr;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        N--;
    }

    public void traverse() {
        traverse(first);
    }

    public static void traverse(Node start) {
        for (Node n = start; n != null; n = n.next) {
            System.out.print(String.format("| %s ", n.item));
        }
        System.out.println();
    }

    public static void main(String s[]) throws Exception {
        //LinkedList <String> l = new LinkedList <>();
        LinkedList <Integer> l = new LinkedList <>();
        l.add(1);
        l.add(2);
        l.add(4);

        l.traverse();
        System.out.println("max: " + l.max());
        l.add(5);
        l.traverse();
        System.out.println("maxR: " + l.max());

        Node r = l.reverse();
        traverse(r);

/*
 *
 *    Node a = new Node("a");
 *    Node b = new Node("b");
 *    a.next = b;
 *    Node c = new Node("c");
 *    b.next = c;
 *    Node d = new Node("d");
 *    c.next = d;
 *    Node e = new Node("e");
 *    d.next = e;
 * //		e.next = c; // loop
 *    e.next = null;
 *
 *    System.out.println(hasLoop(a));
 */
    }
}
