/*
 * COMP-2113 Assignment 2
 * Aidan Carey
 * September 26, 2022
 * Queue.java
 */

public class Queue {
    private int[] array;
    private int front;
    private int rear;

    public Queue() {
        this.array = new int[5];
        this.front = 0;
        this.rear = 0;
    }

    // initialize queue with specific length
    // not required for assignment, but i thought it would be nice to have
    public Queue(int len) {
        this.array = new int[len];
        this.front = 0;
        this.rear = 0;
    }

    // add an element (x) to the queue
    public void enqueue(int x) {
        // if array is full, double array length
        if (isFull()) {
            doubleArray();
        }

        // push all elements back
        for (int i = rear; i != 0; i--) {
            array[i] = array[i-1];
        }
        array[front] = x; // set front to x
        rear++; // set rear to last element index
    }

    // remove an element from the queue,
    // return the element removed or -1 if underflow
    public int dequeue() {
        // if queue is empty, underflow error
        if (isEmpty()) {
            System.out.println("Error: Underflow");
            return -1;
        }

        int x = array[rear-1]; // last element
        rear--; // set rear to new last element + 1
        return x; // return removed element
    }

    // insert an element (x) into the queue at pos
    public void insert(int x, int pos) {
        // if array is full, double array length
        if (isFull()) {
            doubleArray();
        }

        // if position is negative, error
        if (pos < 0) {
            System.out.println("Error: Negative index");
            return;
        }

        // if position is 0, just use enqueue because it does the same thing
        // the for loop used later in this function errors at 0
        if (pos == 0) {
            enqueue(x);
            return;
        }

        // if position is greater than rear:
        if (pos > rear) rear = pos;
        while (pos >= array.length) {
            doubleArray();
        }

        // push all elements back by one
        for (int i = rear; i > pos; i--) {
            array[i] = array[i-1];
        }

        array[pos] = x; // set element at position to be x
        rear++; // set rear to last element index + 1
    }

    // remove an element from the queue at pos
    // return the element removed or -1 if underflow
    public int remove(int pos) {
        // if empty, give underflow error
        if (isEmpty()) {
            System.out.println("Error: Underflow");
            return -1;
        }

        // if position is negative, error
        if (pos < 0) {
            System.out.println("Error: Negative index");
            return -1;
        }

        // if the position is greater than the rear, error
        if (pos >= rear) {
            System.out.println("Error: Position above queue length");
            return -1;
        }

        int x = array[pos]; // set x to removed element
        for (int i = pos; i < rear; i++) {
            array[i] = array[i+1]; // update positions of elements
        }
        rear--; // set rear to new last element + 1
        return x; // return removed element
    }

    // push an element (x) onto queue like a stack
    public void push(int x) {
        // if array is full, double array length
        if (isFull()) {
            doubleArray();
        }

        array[rear] = x; // set element at rear to be x
        rear++; // set rear to last element index + 1
    }

    // pop an element from the queue like a stack
    // return the element removed or -1 if underflow
    public int pop() {
        // in this implementation, dequeue() and pop() are the same
        // using this as a queue is still FILO, and using it as stack is still FIFO
        return dequeue();
    }

    // return first element of the queue, or -1 if underflow
    public int front() {
        // if empty, error and return -1
        if (isEmpty()) {
            return -1;
        } else { // else here is unnecessary, but improves readability
            return array[front]; // return front of queue
        }
    }

    // return true is array is empty, false otherwise
    public boolean isEmpty() {
        return front == rear;
    }

    // return true is array is full, false otherwise
    public boolean isFull() {
        return rear == array.length;
    }

    // double the array and copy previous elements over
    private void doubleArray() {
        System.out.println("Doubling array size from " + array.length + " to " + array.length * 2);
        int[] temp = array; // copy elements to temp
        array = new int[2 * array.length]; // set array to new array of double size
        // copy elements from temp to array
        for (int i = 0; i < temp.length; i++) {
            array[i] = temp[i];
        }
    }

    // completely wipe the array
    // not necessary for assignment but helps with testing
    public void clear() {
        rear = front = 0;
    }

    // create string in form of [1, 2, 3, 4, 5]
    @java.lang.Override
    public java.lang.String toString() {
        String output = "[";
        for (int i = 0; i < rear; i++) {
            output += array[i];
            if (i != rear - 1) {
                output += ", ";
            }
        }
        output += "]";
        return output;
    }
}