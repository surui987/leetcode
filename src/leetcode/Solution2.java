package leetcode;

/**
 * @author surui
 * @date 2020/12/16 10:52 PM
 */
public class Solution2 {
    public static class ListNode {
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        ListNode listNode = addTwoNumbers(l1, l4);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode curr = root;
        int cap = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + cap;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            cap = sum / 10;
            if (null != l1) {
                l1 = l1.next;
            }
            if (null != l2) {
                l2 = l2.next;
            }
        }
        if (cap != 0) {
            curr.next = new ListNode(cap);
        }
        return root.next;

    }
}
