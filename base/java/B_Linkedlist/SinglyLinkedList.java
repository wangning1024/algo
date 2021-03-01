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

    // 查询链表中的值相等节点
    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.getData() != value) {
            p = p.next;
        }
        return p;
    }

    // 查询链表中在index位置的节点
    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            pos++;
        }
        return p;
    }

    // 在表头插入值
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // 在链尾插入
    public void insertTail(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
        } else {
            Node node = head;
            while (node.next != null) {
                node = newNode.next;
            }
            // newNode.next = node.next; 这一步有什么意义？
            node.next = newNode;
        }
    }

    // 在某一节点后插入新节点
    public void insertAfter(Node node, int value) {
        Node newNode = new Node(value, null);
        insertAfter(node, newNode);
    }
    public void insertAfter(Node node, Node newNode) {
        if (node == null) {
            return;
        }
        newNode.next = node.next;
        node.next = newNode;
    }

    // 在某一节的前插入节点
    public void insertBefore(Node node, int value) {
        Node newNode = new Node(value, null);
        insertBefore(node, newNode);
    }
    public void insertBefore(Node node, Node newNode) {
        if (node == null) {
            return;
        }
        if (node == head) {
            insertToHead(newNode);
            return;
        }

        Node p = head.next; // Node p = head
        // 需要校验 p == null的情况
        while (p != null && p != node) {
            p = p.next;
        }
        if (p == null) {
            return;
        }
        newNode.next = node;
        p.next = newNode;
    }

    // 删除节点
    public void deleteByNode(Node p) {
        if (p == null || head == null) { // head == null 时也直接返回
            return;
        }
        if (p == head) {
            head = head.next;
            return;
        }
        Node node = head;
        // 直接判断node.next这样就不用再寻找父节点了
        while (node != null &&  p != node.next) {
            node = node.next;
        }
        if (node == null) {
            return;
        }
        node.next = node.next.next; // todo 不应该是 node = node.next.next; ？

    }

    // 按照值删除
    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }
        if (head.data == value) {
            head = head.next;
            return;
        }
        Node node = head;
        while (node != null && node.next.getData() != value) {
            node = node.next;
        }
        if (node == null) {
            return;
        }
        node.next = node.next.next;

        // 王争的写法:
//        if (head == null) return;
//
//        Node p = head;
//        Node q = null;
//        while (p != null && p.data != value) {
//            q = p;
//            p = p.next;
//        }
//
//        if (p == null) return;
//
//        if (q == null) {
//            head = head.next;
//        } else {
//            q.next = q.next.next;
//        }
    }

    // 可重复删除指定value
    public void deleteByValue(int value, boolean repeat) {
        //
        if (head != null && head.data == value) {
            head = head.next;
        }

        Node pNode = head;
        while (pNode != null) {
            if (pNode.next.data == value) {
                pNode.next = pNode.next.next;
                continue; // 必须有，否则就会执行下面的 pNode = pNode.next;
            }
            pNode = pNode.next;
        }
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


