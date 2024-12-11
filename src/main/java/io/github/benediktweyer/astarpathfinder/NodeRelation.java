package io.github.benediktweyer.astarpathfinder;

/**
 * Explains the relation of a node who has this object and the specified target node.
 * Travel costs between those nodes can be specified.
 */
public class NodeRelation {
    private Node targetNode;
    private double travelCosts;

    /**
     * Constructor for a node relation
     * @param targetNode the target node that the node who has this object is linked to
     * @param travelCosts travel costs from node who has this object to target node
     */
    public NodeRelation(Node targetNode, double travelCosts) {
        this.targetNode = targetNode;
        this.travelCosts = travelCosts;
    }


    public Node getTargetNode() {
        return targetNode;
    }


    public void setTargetNode(Node targetNode) {
        this.targetNode = targetNode;
    }


    public double getTravelCosts() {
        return travelCosts;
    }


    public void setTravelCosts(double travelCosts) {
        this.travelCosts = travelCosts;
    }


    @Override
    public String toString() {
        return "NodeRelation [targetNode=" + targetNode.hashCode() + ", travelCosts=" + travelCosts + "]";
    }
}
