package io.github.benediktweyer.astarpathfinder;

import java.util.HashSet;
import java.util.Set;

/**
 * A node for use in the a star pathfinder
 */
public class Node {
	private Node parentNode;
	
	private double GCost=0;
	private double FCost=Double.MAX_VALUE;
	private double HCost;
	
	private boolean theWay=false;
	private boolean passable=true;

	private Set<NodeRelation> nodeRelations = new HashSet<>();

	/**
	 * Create blank node
	 */
	public Node(){}

	public Node getParentNode(){
		return parentNode;
	}

	public void setParentNode(Node parentNode){
		this.parentNode = parentNode;
	}

	public double getGCost(){
		return GCost;
	}

	public void setGCost(double gCost){
		GCost = gCost;
	}

	public double getFCost(){
		return FCost;
	}

	public void setFCost(double fCost){
		FCost = fCost;
	}

	public double getHCost(){
		return HCost;
	}

	public void setHCost(double hCost){
		HCost = hCost;
	}

	public boolean isTheWay(){
		return theWay;
	}

	public void setTheWay(boolean theWay){
		this.theWay = theWay;
	}

	public boolean isPassable(){
		return passable;
	}

	public void setPassable(boolean passable){
		this.passable = passable;
	}

	public Set<NodeRelation> getNodeRelations(){
		return nodeRelations;
	}

	@Override
	public String toString() {
		return "Node [GCost=" + GCost + ", FCost=" + FCost + ", HCost=" + HCost + ", theWay="
				+ theWay + ", passable=" + passable + ", nodeRelations=" + nodeRelations + "]";
	}
}
