package leetcode;

import java.util.*;

/**
 * @author surui
 * @date 2020/12/14 11:21 PM
 */
public class Solution49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.get(key);
            if (null == list) {
                list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                list.add(str);
            }
        }
        Collection<List<String>> values = map.values();
        return new ArrayList<>(values);
    }
}
