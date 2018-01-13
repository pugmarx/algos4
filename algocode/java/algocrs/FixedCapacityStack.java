import java.util.Scanner;

public class FixedCapacityStack <T> {
    int size;
    int capacity;
    Stack <T> stack;

    public FixedCapacityStack(int capacity) {
        this.capacity = capacity;
        stack         = new Stack <T>();
    }

    public void push(T item) {
        if (size == capacity) {
            pop();
        }
        size++;
        stack.push(item);
    }

    public T pop() {
        if (size > 0) {
            size--;
        }
        return(stack.pop());
    }

    public int getSize() {
        return(size);
    }

    public void print() {
        stack.print();
    }

    public static void main(String s[]) throws Exception {
        FixedCapacityStack <String> fcs = new FixedCapacityStack <>(6);
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String w = sc.next();
            if (w.trim().equals("")) {
                continue;
            }
            if (w.equals("-")) {
                fcs.pop();
            }
            else{
                fcs.push(w);
            }
        }

        //fcs.push("a");
        //fcs.push("b");
        //fcs.push("c");
        //fcs.push("d");
        //fcs.push("e");

        fcs.print();
    }
}
