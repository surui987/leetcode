package leetcode;

/**
 * @author surui
 * @date 2021/3/22 11:03 PM
 */
public class Solution130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int nr = board.length;
        int nc = board[0].length;
        UnionFind uf = new UnionFind(board);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (board[r][c] == 'O') {
                    if (r == 0 || r == nr - 1 || c == 0 || c == nc - 1) {
                        uf.union(r * nc + c, nr * nc);
                    } else {
                        if (r - 1 >= 0 && board[r - 1][c] == 'O') {
                            uf.union(r * nc + c, (r - 1) * nc + c);
                        }
                        if (r + 1 < nr && board[r + 1][c] == 'O') {
                            uf.union(r * nc + c, (r + 1) * nc + c);
                        }
                        if (c - 1 >= 0 && board[r][c - 1] == 'O') {
                            uf.union(r * nc + c, r * nc + c - 1);
                        }
                        if (c + 1 < nc && board[r][c + 1] == 'O') {
                            uf.union(r * nc + c, r * nc + c + 1);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (uf.isConnected(i * nc + j, nr * nc)) {
                    // 和dummyNode 在一个连通区域的,那么就是O；
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n + 1];
            rank = new int[m * n + 1];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    parent[i * n + j] = i * n + j;
                    ++count;
                    rank[i * n + j] = 0;
                }
            }
            parent[m * n] = m * n;
            rank[m * n] = 0;
        }

        public int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                parent[rooty] = rootx;
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public int getCount() {
            return count;
        }

    }
}

