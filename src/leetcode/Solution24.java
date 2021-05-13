package leetcode;

/**
 * @author surui
 * @date 2021/5/12 12:16 上午
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode listNode = swapPairs(nextNode.next);
        head.next = listNode;
        nextNode.next = head;
        return nextNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        Solution24 solution24 = new Solution24();
        solution24.swapPairs(listNode1);
    }
}
