/* COMP-2116 - Assignment 3
 * Aidan Carey
 * October 2, 2022
 * DoublyLinkedList.java
 */

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // insert at the end of the list
    public void insertEnd(int data) {
        // if empty
        if (this.head == null) {
            this.head = new Node(data);
            this.tail = this.head;
        } else {
            Node temp = this.head;
            // loop through elements until its the tail
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            Node newNode = new Node(data);
            temp.setNext(newNode);
            newNode.setPrev(temp);
            this.tail = newNode;
        }
    }

    // insert at the beginning of the list
    public void insertBeginning(int data) {
        // if empty
        if (this.head == null) {
            this.head = new Node(data);
            this.tail = this.head;
        } else {
            Node newNode = new Node(data);
            this.head.setPrev(newNode);
            newNode.setNext(this.head);
            this.head = newNode;
        }
    }

    // insert at pos of list
    public void insertPos(int data, int pos) {
        // if position negative
        if (pos < 0) {
            System.out.println("Error, position cannot be negative");
            return;
        }

        // if only element or pos is first element
        if (this.head == null || pos == 0) {
            insertBeginning(data);
            return;
        }

        Node temp = this.head;

        // loop through elements
        for (int i = 0; i < pos-1; i++) {
            // out of range
            if (temp == null) {
                System.out.println("Error: Position out of range");
                return;
            }
            temp = temp.getNext();
        }

        Node newNode = new Node(data);

        Node next = temp.getNext();
        temp.setNext(newNode);
        newNode.setPrev(temp);

        // if not last element
        if (next != null) {
            newNode.setNext(next);
            next.setPrev(newNode);
        }
    }

    // remove first node of list
    public void removeBeginning() {
        // if empty
        if (this.head == null) {
            return;
        }

        // if only element
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
            return;
        }

        // set head to head.next
        this.head = this.head.getNext();
        this.head.setPrev(null);
    }

    // remove last node of list
    public void removeEnd() {
        // if empty
        if (this.head == null) {
            return;
        }

        // if only element
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
            return;
        }

        Node temp = this.head;
        // loop through elements until the next is the tail
        while (temp.getNext() != this.tail) {
            temp = temp.getNext();
        }

        temp.setNext(null); // set next element to null
        this.tail = temp; // set this.tail
    }

    public void removePos(int pos) {
        // if pos negative
        if (pos < 0) {
            System.out.println("Error: Position cannot be negative");
            return;
        }

        // if no elements
        if (this.head == null) {
            return;
        }

        // if only element
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
            return;
        }

        // if its the beginning, just use removeBeginning()
        if (pos == 0) {
            removeBeginning();
            return;
        }

        Node temp = this.head;
        // loop through elements
        for (int i = 0; i < pos - 1; i++) {
            // if out of range
            if (temp == null) {
                System.out.println("Error: Position out of range");
                return;
            }
            temp = temp.getNext();
        }

        Node next = temp.getNext();

        // if not the last element
        if (next.getNext() != null) {
            // set next to the next of the next element
            temp.setNext(next.getNext());
            next.getNext().setPrev(temp);
        } else {
            removeEnd();
        }
    }

    // print list backwards from tail to head
    public String stringBackwards() {
        String s = "";
        Node temp = this.tail;
        if (temp == null) {
            return "[]";
        }
        while (temp != null) {
            s += "[" + temp.getData() + "]";
            temp = temp.getPrev();
            if (temp != null) {
                s += "<->";
            }
        }
        return s;
    }

    // convert list to a string
    @Override
    public String toString() {
        String s = "";
        Node temp = this.head;
        if (temp == null) {
            return "[]";
        }
        while (temp != null) {
            s += "[" + temp.getData() + "]";
            temp = temp.getNext();
            if (temp != null) {
                s += "<->";
            }
        }
        return s;
    }
}
