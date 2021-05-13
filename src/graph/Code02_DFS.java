package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

/**
 * @author surui
 * @date 2021/3/10 11:59 PM
 */
public class Code02_DFS {
    // 深度遍历
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 1}, {0, 2}, {1, 2}, {1, 2}};
        boolean whetherExistsPath = findWhetherExistsPath(3, graph, 0, 2);
        System.out.println(whetherExistsPath);
    }

    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(i);
            nodeMap.put(i, node);
        }
        for (int[] ints : graph) {
            Node firstNode = nodeMap.get(ints[0]);
            Node secondNode = nodeMap.get(ints[1]);
            firstNode.nexts.add(secondNode);
            // Edge edge = new Edge(1, nodeMap.get(ints[0]), nodeMap.get(ints[1]));
        }
        return dfs2(nodeMap.get(start), nodeMap.get(target));
    }

    public static boolean dfs2(Node fromNode, Node toNode) {
        if (fromNode == null) {
            return false;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(fromNode);
        set.add(fromNode);
        System.out.println(fromNode.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    if (next.value == toNode.value) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }

}
