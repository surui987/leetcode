package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author surui
 * @date 2021/5/6 8:39 下午
 */
public class Solution109 {
    Map<Integer, Integer> map;
    List<Integer> list;

    public static void main(String[] args) {
        Solution109 solution109 = new Solution109();
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        solution109.sortedListToBST(node1);
    }

    public TreeNode sortedListToBST(ListNode head) {
        map = new HashMap();
        list = new ArrayList<>();
        int index = 0;
        ListNode nextNode = head;

        while (nextNode != null) {
            map.put(nextNode.val, index);
            list.add(nextNode.val);
            index++;
            nextNode = nextNode.next;
        }
        TreeNode treeNode = myTreeNode(list, 0, list.size() - 1);
        return treeNode;
    }

    public TreeNode myTreeNode(List<Integer> list, int first, int last) {
        if (first > last) {
            return null;
        }
        int rootIndex;
        if ((last - first) % 2 == 1) {
            rootIndex = (last - first) / 2 + 1 + first;
        } else {
            rootIndex = (last - first) / 2 + first;
        }
        TreeNode treeNode = new TreeNode(list.get(rootIndex));
        treeNode.left = myTreeNode(list, first, rootIndex - 1);
        treeNode.right = myTreeNode(list, rootIndex + 1, last);
        return treeNode;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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
}
