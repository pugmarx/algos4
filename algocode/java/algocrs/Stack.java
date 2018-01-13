/**
 *      Singly-linked-list
 *      n -> n+1 ---> n+k
 **/

/**
 * class Node{
 *      String item;
 *      Node next;
 *      public Node(){}
 *      public Node(String item){
 *              this.item = item;
 *      }
 * }
 **/
public class Stack <T> {
    LinkedList <T> l;

    public Stack() {
        l = new LinkedList <T>();
    }

    public void push(T item) {
        l.add(item);
    }

    public T pop() {
        return((T)(l.remove()));
    }

    public boolean isEmpty() {
        return(l.size() == 0);
    }

    public void print() {
        l.traverse();
    }

    public static void main(String args[]) throws Exception {
        Stack <String> s = new Stack <>();

        for (String a: args) {
            if (a.equals("-")) {
                s.pop();
            }
            else{
                s.push(a);
            }
        }
//		s.push("b");
//		s.push("c");
//		s.push("d");
        s.print();
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        //s.print();
//		System.out.println(s.pop());
        //System.out.println(s.pop());
        //	System.out.println(s.pop());
        //	System.out.println(s.pop());
    }
}
