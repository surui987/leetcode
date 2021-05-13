package learning.dfsbfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author surui
 * @date 2021/3/15 11:08 PM
 */
public class Code02_BFS {
    // 宽度遍历
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
