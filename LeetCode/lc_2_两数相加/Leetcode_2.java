package lc_2_两数相加;

/**
 *2.两数相加
 */
class Leetcode_2 {

    /**
     * 使用补齐链表的方法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        int length1 = 0;
        int length2 = 0;
        ListNode temp1 = l1;
        while (temp1 != null) {
            length1++;
            temp1 = l1.next;
        }

        ListNode temp2 = l2;
        while (temp2 != null) {
            length2++;
            temp2 = l2.next;
        }
        // 上两个遍历之后，temp1和temp2已经到达链表最后
        if (length1 > length2) {
            // 补齐第二个链表
            for (int i = 0; i < length1 - length2; i++) {
                temp2.next = new ListNode(0);
                temp2 = temp2.next;
            }
        }
        if (length2 > length1) {
            // 补齐第一个链表
            for (int i = 0; i < length2 - length1; i++) {
                temp1.next = new ListNode(0);
                temp1 = temp1.next;
            }
        }
        // 重新指回链表头
        temp1 = l1;
        temp2 = l2;
        boolean isCount = false; // 记录是否进位
        ListNode sumListNode = new ListNode(-1);
        // 记录住求和的列表的头记录
        ListNode result = sumListNode;
        while (temp1 != null && temp2 != null) {
            int sum = temp1.val + temp2.val;
            sumListNode.next = new ListNode(sum % 10);
            isCount = sum >= 10;
            sumListNode = sumListNode.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if (isCount) {
            sumListNode.next = new ListNode(1);
        }

        // 返回的是求和的链表，从第二个节点开始的部分
        return result.next;
    }

    /**
     * 不使用补齐链表的方法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode result = head;
        int sum = 0;
        boolean isCarry = false;
        while (l1 != null || l2 != null) {
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (isCarry) {
                sum++;
            }
            head.next = new ListNode(sum % 10);
            head = head.next;
            isCarry = sum >= 10;
        }
        if (isCarry) {
            head.next = new ListNode(1);
        }
        return result.next;
    }

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}