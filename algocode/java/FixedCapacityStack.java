import java.util.Scanner;

public class FixedCapacityStack {
   int size;
   int capacity;
   Stack stack;

   public FixedCapacityStack(int capacity) {
      this.capacity = capacity;
      stack         = new Stack();
   }

   public void push(String item) {
      if (size == capacity) {
         pop();
      }
      size++;
      stack.push(item);
   }

   public String pop() {
      if (size > 0) {
         size--;
      }
      return((String)stack.pop());
   }

   public int getSize() {
      return(size);
   }

   public void print() {
      stack.print();
   }

   public static void main(String s[]) throws Exception {
      FixedCapacityStack fcs = new FixedCapacityStack(6);
      Scanner            sc  = new Scanner(System.in);

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
