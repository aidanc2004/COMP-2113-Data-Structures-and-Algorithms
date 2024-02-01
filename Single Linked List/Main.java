/* COMP-2116 - Assignment 3
 * Aidan Carey
 * October 2, 2022
 * Main.java
 */

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        for (int i = 5; i <= 25; i += 5) {
            ll.insertEnd(i);
        }

        ll.insertBeginning(2);
        ll.insertBeginning(1);

        ll.insertPos(100, 3);
        ll.insertPos(100, -1);

        System.out.println(ll);

        ll.removeBeginning();
        ll.removeBeginning();

        ll.removeEnd();
        ll.removeEnd();

        ll.removePos(1);
        ll.removePos(2);

        ll.removePos(100); // error testing
        ll.removePos(-10); // error testing

        ll.insertPos(1, 100); // error testing

        System.out.println(ll);
    }
}