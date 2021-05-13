package leetcode.leetcode20210110;

import java.util.ArrayList;
import java.util.List;

/**
 * @author surui
 * @date 2021/1/10 10:59 AM
 */
public class Solution5652 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        /*ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);*/
        listNode1.next = listNode2;
        /*listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;*/
        ListNode listNode = swapNodes(listNode1, 2);
        System.out.println(listNode);

    }

    public static ListNode swapNodes(ListNode head, int k) {
        List<ListNode> listNodes = new ArrayList<>();
        ListNode indexListNode = head;
        listNodes.add(indexListNode);
        while (indexListNode.next != null) {
            listNodes.add(indexListNode.next);
            indexListNode = indexListNode.next;
        }
        if (listNodes.size() == 1) {
            return head;
        }
        if (listNodes.size() - k == k - 1) {
            return head;
        }
        if (k == 1 || k == listNodes.size()) {
            ListNode y = head;
            int item = head.val;
            while (y.next != null) {
                y = y.next;
            }
            int vallast = y.val;
            head.val = vallast;
            y.val = item;
            return head;
        }
        if (listNodes.size() == 2 && (listNodes.size() == k || k == 1)) {
            ListNode next = head.next;
            int item = head.val;
            head.val = next.val;
            next.val = item;
            return head;
        }
        ListNode first = listNodes.get(k - 1);
        ListNode second = listNodes.get(listNodes.size() - k);
        int val1 = first.val;
        int val2 = second.val;
        ListNode m = head;
        int index1 = 0;
        ListNode next = new ListNode();
        while (index1 < k - 1) {
            index1++;
            next = m.next;
            m = m.next;
        }
        next.val = val2;

        ListNode n = head;
        int index2 = 0;
        ListNode next2 = new ListNode();
        while (index2 < listNodes.size() - k) {
            index2++;
            next2 = n.next;
            n = n.next;
        }
        next2.val = val1;
        return head;
    }


}
