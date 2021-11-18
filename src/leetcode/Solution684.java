package leetcode;

/**
 * 并查集
 *
 * @author surui
 * @date 2021/10/26 11:00 下午
 */
public class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {
        int max = 0;
        for (int[] edge : edges) {
            for (int i : edge) {
                max = Math.max(max, i);
            }
        }
        UnionFind unionFind = new UnionFind(max);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            boolean union = unionFind.union(x - 1, y - 1);
            if (union) {
                return edge;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Solution684 solution = new Solution684();
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] redundantConnection = solution.findRedundantConnection(edges);
        System.out.println(redundantConnection);
    }

    public class UnionFind {
        public int count;
        public int[] parent;

        public UnionFind(int num) {
            count = num;
            parent = new int[num];
            for (int i = 0; i < num; i++) {
                parent[i] = i;
            }
        }

        public boolean union(int x, int y) {
            int rootx = findParent(x);
            int rooty = findParent(y);
            if (rootx != rooty) {
                parent[rootx] = rooty;
                count--;
                return false;
            }
            return true;
        }

        public int findParent(int x) {
            if (parent[x] != x) {
                parent[x] = findParent(parent[x]);
            }
            return parent[x];
        }
    }
}
