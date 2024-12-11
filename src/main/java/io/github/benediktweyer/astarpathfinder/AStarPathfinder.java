package io.github.benediktweyer.astarpathfinder;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Tries to find the shortest path using the a-star algorithm
 */
public class AStarPathfinder {
    private Set<Node> nodes;
    private Node startNode;
    private Node endNode;

    private boolean foundPath = false;

    private double hCostMultiplier = 2;

    //private List<Node> allList = new ArrayList<>();
	private Set<Node> openSet = new HashSet<>();
	private Set<Node> closedSet = new HashSet<>();

    private Node currentNode = null;

    /**
     * Constructor for the pathfinder
     * 
     * @param nodes a set of all nodes with set h-costs and relations
     * @param startNode the starting node of the path
     * @param endNode the end node of the path
     */
    public AStarPathfinder(Set<Node> nodes, Node startNode, Node endNode) {
        this.nodes = nodes;
        this.startNode = startNode;
        this.endNode = endNode;

        this.currentNode = startNode;
        this.closedSet.add(startNode);
    }


    
    /** 
     * Calculates the path.
     * 
     * @return if path was found
     */
    public boolean calculate(){

        boolean pathFound = false;
        while(!pathFound){
            pathFound = calculateNextStep();
        }

        return true;
    }

    /**
     * Calculates the next step of the pathfinding algorithm.
     * @return if path was found
     */
    public boolean calculateNextStep(){
        if(foundPath) return true;

        //move current node to closed list
        openSet.remove(currentNode);
        closedSet.add(currentNode);

        //check neighbour nodes
        for(NodeRelation nodeRelation : currentNode.getNodeRelations()){
            
            Node neighbourNode = nodeRelation.getTargetNode();

            if(!closedSet.contains(neighbourNode) && neighbourNode.isPassable()){
                double gCosts = currentNode.getGCost() + nodeRelation.getTravelCosts();
                double fCosts = gCosts + nodeRelation.getTargetNode().getHCost() * hCostMultiplier;
    
                //set/update f and g cost and parent node
                if(neighbourNode.getFCost() > fCosts){
                    neighbourNode.setGCost(gCosts);
                    neighbourNode.setFCost(fCosts);
                    neighbourNode.setParentNode(currentNode);
                }
                
    
                //add neighbour nodes to open list
                openSet.add(neighbourNode);
            }
        }


        Node nextNode = openSet.stream()
            .min(
                Comparator.comparingDouble(Node::getFCost)
                .thenComparing(Node::getHCost)
                )
            .orElse(null);

        System.out.println(String.format("Next Node: %s\n", nextNode));

        if(nextNode != null){
            currentNode = nextNode;
        }
        

        //check for end node
        if(currentNode.equals(endNode)){
            //found path!
            foundPath = true;

            //backtrace path
            backtraceFoundPath(currentNode);
            
        }


        return false;
    }

    /**
     * Backtraces found path and marks it as the way
     * @param endNode the end node
     */
    private void backtraceFoundPath(Node endNode){

        Node nextBacktraceNode = endNode;

        while(!nextBacktraceNode.equals(startNode)){
            nextBacktraceNode.setTheWay(true);
            nextBacktraceNode = nextBacktraceNode.getParentNode();
        }

        startNode.setTheWay(true);
    }

    /**
     * Get the open set
     * @return open set
     */
    public Set<Node> getOpenSet() {
        return openSet;
    }

     /**
     * Get the closed set
     * @return closed set
     */
    public Set<Node> getClosedSet() {
        return closedSet;
    }
}
