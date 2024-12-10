package com.benediktweyer.astarpathfinder;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;


public class AStarPathfinderTest {

    @Test
    void simplePath() {
        //create nodes
        Node n1 = new Node();
        Node n2 = new Node();

        //set h cost of nodes
        n1.setHCost(2);
        n2.setHCost(0);

        //add node relations
        n1.getNodeRelations().add(new NodeRelation(n2, 2));

        //group all nodes
        Set<Node> allNodes = new HashSet<>();
        allNodes.add(n1);
        allNodes.add(n2);

        //create pathfinder instance
        AStarPathfinder aStarPathfinder = new AStarPathfinder(allNodes, n1, n2);

        //calculate path
        bool foundPath = aStarPathfinder.calculate();

        //check for success
        assertThat(foundPath)
            .isEqualTo(true);

        assertThat(n1.isTheWay())
            .isEqualTo(true);

        assertThat(n2.isTheWay())
            .isEqualTo(true);

        assertThat(n2.getParentNode())
            .isEqualTo(n1);
    }
}
