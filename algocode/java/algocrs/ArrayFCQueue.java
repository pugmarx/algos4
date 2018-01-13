/**
 * Array impl. of a FixedCapacityQueue
 **/

@SuppressWarnings("unchecked")
public class ArrayFCQueue <T> {
    private T[] arr;
    private int N;
    private int head;
    private int capacity;

    public ArrayFCQueue(int capacity) {
        N             = 0;
        head          = 0;
        this.capacity = capacity;
        arr           = (T[])new Object[capacity];
    }

    public boolean isEmpty() {
        return(N == 0);
    }

    public boolean isFull() {
        return(N == capacity);
    }

    public T peek() {
        return(arr[N - 1]);
    }

    private void resizeArray(int toSize) {
        T[] newArray = (T[])new Object[toSize];
        for (int i = 0; i < N; i++) {
            newArray[i] = arr[i];
        }
        arr = newArray;
    }

    // Double the size if full
    public void enqueue(T t) {
        if (N == capacity) {
            resizeArray(2 * capacity);
        }
        arr[N++] = t;
    }

    // Halve the size if array is half empty
    public T dequeue() {
        if (N <= capacity / 4) {
            resizeArray(capacity / 2);
        }
        T tmp = null;
        if (N > 0) {
            tmp = arr[head];
            shiftLeft();
            arr[--N] = null;
            //N--;
        }
        return(tmp);
    }

    private void shiftLeft() {
        for (int i = 0; i < N - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.print(arr[i] + " |");
            }
            else{
                System.out.print(" - |");
            }
        }
        System.out.println();
    }

    public static void main(String arg[]) {
        ArrayFCQueue <String> afcs = new ArrayFCQueue <>(6);
        afcs.enqueue("a");
        afcs.print();
        afcs.enqueue("b");
        afcs.print();
        afcs.enqueue("c");
        afcs.print();
        afcs.enqueue("d");
        afcs.print();
        afcs.enqueue("e");
        afcs.print();
        afcs.enqueue("f");
        afcs.print();
        afcs.dequeue();
        afcs.print();
        afcs.dequeue();
//		afcs.pop();
//		afcs.pop();
//		System.out.println(afcs.peek());
        afcs.print();
        afcs.dequeue();
        afcs.print();
        afcs.dequeue();
        afcs.print();
        afcs.dequeue();
        afcs.print();
        afcs.dequeue();
        afcs.print();
        afcs.dequeue();
        afcs.print();
        afcs.dequeue();
        afcs.print();
        afcs.dequeue();
        afcs.print();
        afcs.dequeue();
//		afcs.pop();
//		afcs.pop();
//		System.out.println(afcs.peek());
        afcs.print();
    }
}
