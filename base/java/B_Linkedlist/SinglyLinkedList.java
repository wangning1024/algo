package B_Linkedlist;

public class SinglyLinkedList {

    private Node head = null;

    public Node findByValue(int value) {

        Node p = head;
        while (p != null && p.getData() != value) {
            p = p.next;
        }
        return p;
    }


    public class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return this.data;
        }
    }
}
