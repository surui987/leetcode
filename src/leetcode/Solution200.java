package leetcode;

/**
 * 并查集
 *
 * @author surui
 * @date 2021/10/27 10:30 下午
 */
public class Solution200 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        UnionFind unionFind = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    total++;
                    grid[i][j] = '0';
                    if (j < n - 1 && grid[i][j + 1] == '1') {
                        unionFind.union(i * n + j, i * n + j + 1);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        unionFind.union(i * n + j, i * n + j - 1);
                    }
                    if (i > 0 && grid[i - 1][j] == '1') {
                        unionFind.union(i * n + j, (i - 1) * n + j);
                    }
                    if (i < m - 1 && grid[i + 1][j] == '1') {
                        unionFind.union(i * n + j, (i + 1) * n + j);
                    }
                }
            }
        }
        return total - (m * n - unionFind.getCount());
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        Solution200 solution = new Solution200();
        int i = solution.numIslands(grid);
        System.out.println(i);
    }

    class UnionFind {
        public int count;
        public int[] parents;

        public UnionFind(int num) {
            count = num;
            parents = new int[num];
            for (int i = 0; i < num; i++) {
                parents[i] = i;
            }
        }

        public int findParent(int x) {
            if (x != parents[x]) {
                parents[x] = findParent(parents[x]);
            }
            return parents[x];
        }

        public void union(int x, int y) {
            int xroot = findParent(x);
            int yroot = findParent(y);
            if (xroot != yroot) {
                count--;
                parents[yroot] = xroot;
            }
        }

        public int getCount() {
            return count;
        }
    }
}
