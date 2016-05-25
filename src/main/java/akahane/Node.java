package akahane;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by n.akahane on 2016/05/25.
 */
public class Node {

    private List<Node> edgesTo = new ArrayList<>();
    private List<Integer> edgesCost = new ArrayList<>();
    private int cost = -1;
    private boolean done = false;
    private String id = null;
    private Node previousNode = null;

    public Node(String id){
        this.id = id;
    }

    public void addNode(Node to, int cost){
        this.edgesTo.add(to);
        this.edgesCost.add(cost);
    }

    public List<Node> getEdgesTo() {
        return edgesTo;
    }

    public void setEdgesTo(List<Node> edgesTo) {
        this.edgesTo = edgesTo;
    }

    public List<Integer> getEdgesCost() {
        return edgesCost;
    }

    public void setEdgesCost(List<Integer> edgesCost) {
        this.edgesCost = edgesCost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
