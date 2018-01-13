/**
 * Array impl. of a FixedCapacityStack
 **/

@SuppressWarnings("unchecked")
public class ArrayFCStack <T> {
    private T[] arr;
    private int size;
    private int capacity;

    public ArrayFCStack(int capacity) {
        size          = 0;
        this.capacity = capacity;
        arr           = (T[])new Object[capacity];
    }

    public boolean isEmpty() {
        return(size == 0);
    }

    public boolean isFull() {
        return(size == capacity);
    }

    public T peek() {
        return(arr[size - 1]);
    }

    private void resizeArray(int toSize) {
        T[] newArray = (T[])new Object[toSize];
        for (int i = 0; i < size; i++) {
            newArray[i] = arr[i];
        }
		capacity = toSize; // new capacity
        arr = newArray;
    }

    // Double the size if full
    public void push(T t) {
        if (size == capacity) {
            resizeArray(2 * capacity);
        }
        arr[size++] = t;
    }

    // Halve the size if array is 3 quarters empty
    public T pop() {
        if (size <= capacity / 4) {
            resizeArray(capacity / 2);
        }
        T tmp = null;
        if (size > 0) {
            tmp       = arr[--size];
            arr[size] = null;
        }
        return(tmp);
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
        ArrayFCStack <String> afcs = new ArrayFCStack <>(6);
        afcs.push("a");
        afcs.push("b");
        afcs.push("c");
        afcs.push("d");
        afcs.pop();
        afcs.pop();
//		afcs.pop();
//		afcs.pop();
        System.out.println(afcs.peek());
        afcs.print();
    }
}
