package lc_19_删除链表倒数第n个数据;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        int length = 0;
        ListNode node = head.next;
        while (node != null) {
            node = node.next;
            length++;
        }

        int index = length - n;
        int m = 1;
        ListNode node1 = head.next;
        while (m <= index && node1 != null) {
            node1 = node1.next;
            m++;
        }

        return null;

    }

    class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
