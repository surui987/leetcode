package leetcode;

/**
 * @author surui
 * @date 2021/5/11 11:17 下午
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        process(l1, l2, listNode);
        return listNode.next;
    }

    public void process(ListNode l1, ListNode l2, ListNode curr) {
        if (l1 == null) {
            curr.next = l2;
            return;
        }
        if (l2 == null) {
            curr.next = l1;
            return;
        }
        if (l1.val <= l2.val) {
            curr.next = l1;
            l1 = l1.next;
        } else {
            curr.next = l2;
            l2 = l2.next;
        }
        process(l1, l2, curr.next);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
