package learning.dfsbfs;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author surui
 * @date 2021/3/10 11:22 PM
 */
public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
