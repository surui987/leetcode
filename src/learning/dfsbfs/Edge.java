package learning.dfsbfs;

/**
 * @author surui
 * @date 2021/3/10 11:19 PM
 */
public class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
