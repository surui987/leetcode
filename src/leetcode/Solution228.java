package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author surui
 * @date 2021/1/10 12:53 AM
 */
public class Solution228 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> list = summaryRanges(nums);
        System.out.println(list);
    }

    public static List<String> summaryRanges(int[] nums) {
        if (nums.length==0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (deque.isEmpty()) {
                deque.addLast(nums[i]);
            } else {
                if (deque.peekLast() + 1 == nums[i]) {
                    deque.addLast(nums[i]);
                } else {
                    result.add(new ArrayList<>(deque));
                    deque.clear();
                    deque.addLast(nums[i]);
                }
            }
        }
        result.add(new ArrayList<>(deque));
        List<String> resultList = new ArrayList<>();
        for (List<Integer> list : result) {
            StringBuilder sb = new StringBuilder();
            if (list.size() == 1) {
                sb.append(list.get(0));
            } else if(list.size() > 1){
                sb.append(list.get(0)).append("->").append(list.get(list.size() - 1));
            }
            resultList.add(sb.toString());
        }
        return resultList;
    }
}
