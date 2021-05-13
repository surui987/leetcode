package learning.bean;

/**
 * @author surui
 * @date 2020/12/16 10:52 PM
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
