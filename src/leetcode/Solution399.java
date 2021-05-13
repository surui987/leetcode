package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author surui
 * @date 2021/4/20 11:06 PM
 */
public class Solution399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();
        UnionFind unionFind = new UnionFind(size * 2);
        Map<String, Integer> map = new HashMap<>(2 * size);
        int id = 0;
        for (int i = 0; i < size; i++) {
            List<String> equation = equations.get(i);
            String first = equation.get(0);
            String second = equation.get(1);
            if (!map.containsKey(first)) {
                map.put(first, id);
                id++;
            }
            if (!map.containsKey(second)) {
                map.put(second, id);
                id++;
            }
            unionFind.union(map.get(first), map.get(second), values[i]);
        }

        int querysize = queries.size();
        double[] result = new double[querysize];
        for (int i = 0; i < querysize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = map.get(var1);
            Integer id2 = map.get(var2);

            if (id1 == null || id2 == null) {
                result[i] = -1.0d;
            } else {
                result[i] = unionFind.isConnected(id1, id2);
            }
        }
        return result;
    }


    private class UnionFind {
        private int[] parent;
        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] =1.0d;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] = weight[origin] * weight[x];
            }
            return parent[x];
        }

        public void union(int x, int y, double value) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty) {
                return;
            }
            parent[rootx] = rooty;
            weight[rootx] = weight[y] * value / weight[x];
        }

        public double isConnected(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }
}
