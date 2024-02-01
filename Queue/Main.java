/*
 * COMP-2113 Assignment 2
 * Aidan Carey
 * September 26, 2022
 * Main.java
 */

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue();

        // enqueue() and dequeue()
        System.out.println("Enqueue and Dequeue:");
        System.out.println(q);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q);
        q.dequeue();
        q.dequeue();
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        System.out.println(q);

        q.clear(); // wipe array

        // insert() and remove()
        System.out.println("\nInsert and Remove:");

        for (int i = 1; i <= 5; i++) q.push(i); // put 1..5 in array
        System.out.println(q);

        q.insert(10, 1);
        q.insert(20, 3);
        System.out.println(q);
        q.remove(2);
        q.remove(3);
        System.out.println(q);

        q.insert(5, 15); // above array.length
        q.remove(30); // above array.length

        q.insert(404, -1); // negative
        q.remove(-1); // negative

        q.insert(7, 0); // zero
        q.remove(0); // zero

        System.out.println(q);

        q.clear();

        // push() and pop()
        System.out.println("\nPush and Pop:");
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q);
        q.pop();
        q.pop();
        System.out.println(q);

        q.clear();

        // isFull() and isEmpty()
        System.out.println("\nisEmpty and isFull:");
        System.out.println(q);
        System.out.println("isEmpty: " + q.isEmpty());
        System.out.println("isFull: " + q.isFull());

        for (int i = 1; i <= 20; i++) q.push(i); // fill array

        System.out.println(q);
        System.out.println("isEmpty: " + q.isEmpty());
        System.out.println("isFull: " + q.isFull());

        q.clear();
        for (int i = 0; i <= 5; i++) q.push(i); // partially fill array

        System.out.println(q);
        System.out.println("isEmpty: " + q.isEmpty());
        System.out.println("isFull: " + q.isFull());

        q.clear();

        // front()
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println("\nFront:");
        System.out.println(q.front());
    }
}