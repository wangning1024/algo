package B_Linkedlist;

public class SinglyLinkedList {

        public static int maxProfit(int[] prices) {
            int max = 0;
            int calMax = 0;
            for (int i = 0; i < prices.length; i++) {
                int j = 1;
                if(i + j < prices.length) {
                    int value1 = prices[i + j] - prices[i];
                    int k = 1;
                    while (i + j + 1 < prices.length && i + j + k + 1 < prices.length) {
                        int value2 = prices[i + j + k + 1] - prices[i + j + 1];
                        k++;
                        if (value1 + value2 > max) {
                            max = calMax;
                        }
                    }

                    j++;
                }

            }


            return max;
        }

        public static void main(String[] args) {

            int i = maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
            System.out.println(i);

        }
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
