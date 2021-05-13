package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author surui
 * @date 2020/12/10 11:52 PM
 */
public class Solution860 {
    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        boolean b = lemonadeChange(bills);
        System.out.println(b);
    }

    public static boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> billMap = new HashMap<>();
        billMap.put(5, 0);
        billMap.put(10, 0);
        billMap.put(20, 0);
        for (int bill : bills) {
            if (bill == 5) {
                billMap.put(5, billMap.get(5) + 1);
            } else if (bill == 10) {
                if (billMap.get(5) == null || billMap.get(5) == 0) {
                    return false;
                }
                billMap.put(10, billMap.get(10) + 1);
                billMap.put(5, billMap.get(5) - 1);
            } else {
                if (billMap.get(5) == null || billMap.get(5) == 0) {
                    return false;
                }
                if (billMap.get(10) == null || billMap.get(10) == 0) {
                    if (billMap.get(5) < 3) {
                        return false;
                    }
                    billMap.put(20, billMap.get(20) + 1);
                    billMap.put(5, billMap.get(5) - 3);
                } else {
                    billMap.put(20, billMap.get(20) + 1);
                    billMap.put(10, billMap.get(10) - 1);
                    billMap.put(5, billMap.get(5) - 1);
                }
            }
        }
        return true;
    }
}
