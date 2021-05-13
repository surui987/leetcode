package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author surui
 * @date 2021/1/12 11:50 PM
 */
public class Solution1203 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<Integer> nolist = new ArrayList<>();
        Deque<Integer> itemList = new LinkedList<>();
        for (int i = 0; i < beforeItems.size(); i++) {
            if (beforeItems.get(i).size() == 0) {
                nolist.add(i);
            } else {
                if (itemList.contains(i)) {

                }
                for (Integer integer : beforeItems.get(i)) {
                    if (group[i] == -1) {
                        return new int[1];
                    } else {
                        itemList.addLast(integer);
                    }
                    itemList.addLast(integer);
                }

            }
        }
        return new int[n];
    }
}
