/**
 * Array impl. of a FixedCapacityQueue
 **/

@SuppressWarnings("unchecked")
public class Deque <T> {
    private T[] arr;
    private int N;
    private int head;
    private int tail;
    private int capacity;

    public Deque(int capacity) {
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
    public void pushRight(T t) {
        if (N == capacity) {
            resizeArray(2 * capacity);
        }
        arr[N++] = t;
    }

    // Double the size if full
    public void pushLeft(T t) {
        if (N == capacity) {
            resizeArray(2 * capacity);
        }
        N++;         // FIXME assumption
        shiftRight();
        arr[0] = t;
    }

    public T popRight() {
        if (N <= capacity / 4) {
            resizeArray(capacity / 2);
        }
        T tmp = null;
        if (N > 0) {
            tmp      = arr[N - 1];
            arr[--N] = null;
        }
        return(tmp);
    }

    // Halve the size if array is half empty
    public T popLeft() {
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

    private void shiftRight() {
        for (int i = N; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
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
        Deque <String> dq = new Deque <>(6);
        dq.pushLeft("a");
        dq.print();
        dq.pushLeft("b");
        dq.print();
        dq.pushLeft("c");
        dq.print();
        dq.pushRight("d");
        dq.print();
        System.out.println(dq.popLeft());
        dq.print();
        System.out.println(dq.popRight());
        dq.print();
    }
}
