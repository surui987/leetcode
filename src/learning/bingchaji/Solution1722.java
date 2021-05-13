package learning.bingchaji;

import java.util.*;

/**
 * 并查集
 *
 * @author surui
 * @date 2021/4/19 10:46 PM
 */
public class Solution1722 {
    public static void main(String[] args) {
        int[] source = {1, 2, 3, 4};
        int[] target = {2, 1, 4, 5};
        int[][] allowedSwaps = {{1, 2}, {2, 3}};
        int i = minimumHammingDistance(source, target, allowedSwaps);
        System.out.println(i);
    }

    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int result = 0;
        int n = source.length;
        UnionFindSet unionFindSet = new UnionFindSet(n);
        for (int[] allowedSwap : allowedSwaps) {
            unionFindSet.union(allowedSwap[0], allowedSwap[1]);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            int item = target[i];
            List<Integer> list = map.getOrDefault(item, new LinkedList<>());
            list.add(i);
            map.put(item, list);
        }
        for (int i = 0; i < source.length; i++) {
            int item = source[i];
            if (!map.keySet().contains(item)) {
                result++;
            } else {
                Boolean flag = false;
                List<Integer> list = map.get(item);
                for (int j = 0; j < list.size(); j++) {
                    if (unionFindSet.isConnected(i, list.get(j))) {
                        list.remove(j);
                        map.put(item, list);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    result++;
                }
            }
        }
        return result;
    }

    public static class UnionFindSet {
        private int n;
        private int[] parent;

        public UnionFindSet(int n) {
            this.n = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            int index1 = find(x);
            int index2 = find(y);
            if (index1 == index2) {
                return;
            }
            parent[index1] = index2;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}


