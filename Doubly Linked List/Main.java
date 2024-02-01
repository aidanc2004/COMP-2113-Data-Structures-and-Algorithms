/* COMP-2116 - Assignment 3
 * Aidan Carey
 * October 2, 2022
 * Main.java
 */

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList ll = new DoublyLinkedList();

        for (int i = 5; i <= 25; i += 5) {
            ll.insertEnd(i);
        }

        System.out.println(ll);
        System.out.println(ll.stringBackwards());

        ll.insertBeginning(2);
        ll.insertBeginning(1);

        ll.insertPos(3, 2);
        ll.insertPos(10, 100);
        ll.insertPos(123, -1);

        ll.removeBeginning();
        ll.removeBeginning();

        ll.removeEnd();

        System.out.println(ll);

        ll.removePos(1);
        ll.removePos(-1);
        ll.removePos(100);
        ll.removePos(3);

        System.out.println(ll);
        System.out.println(ll.stringBackwards());
    }
}