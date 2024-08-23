package depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private int value;
    private boolean visited;

    private Node father;
    private List<Node> connectedNodes = new ArrayList<>();

    private int distanceFromStartPoint=  0;


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public List<Node> getConnectedNodes() {
        return connectedNodes;
    }

    public void setConnectedNodes(List<Node> connectedNodes) {
        this.connectedNodes = connectedNodes;
    }

    public int getDistanceFromStartPoint() {
        return distanceFromStartPoint;
    }

    public void setDistanceFromStartPoint(int distanceFromStartPoint) {
        this.distanceFromStartPoint = distanceFromStartPoint;
    }

    public void addNodeToConnectedNodes(Node node){
        connectedNodes.add(node);
    }
}
