package akahane;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by n.akahane on 2016/05/25.
 */
public class Main {

    public static void main(String[] args) {
        List<Node> nodes = createNodes();

        // start node is first node
        Node startNode = nodes.get(0);
        startNode.setCost(0);


        while (true) {
            Node processNode = null;

            for (int i = 0; i < nodes.size(); i++) {
                Node node = nodes.get(i);

                // 訪問済み or まだコストが未設定
                if (node.isDone() || node.getCost() < 0) {
                    continue;
                }

                if (processNode == null) {
                    processNode = node;
                    continue;
                }

                // 一番小さいコストのノードを探す
                if (node.getCost() < processNode.getCost()) {
                    processNode = node;
                }
            }

            if (processNode == null) {
                break;
            }

            processNode.setDone(true);

            for (int i = 0; i < processNode.getEdgesTo().size(); i++) {
                Node node = processNode.getEdgesTo().get(i);
                int cost = processNode.getCost() + processNode.getEdgesCost().get(i);

                // コストが未設定 or コストの少ない経路がある場合はアップデート
                boolean needsUpdate = (node.getCost() < 0) || (node.getCost() > cost);
                if (needsUpdate) {
                    node.setCost(cost);
                    node.setPreviousNode(processNode);
                    System.out.println("setPreviousNode: " + processNode.getId());
                }
                else{
                    System.out.println("hoge: ");
                }
            }
        }

        System.out.println("Has been done to search path.");
        System.out.println(nodes);

        Node goalNode = nodes.get(5);
        System.out.println("Shoten cost is " + goalNode.getCost());

        System.out.println("Shoten path");

        System.out.println("=====================");
        String path = "Goal -> ";
        Node currentNode = goalNode;
        while(true) {
            Node nextNode = currentNode.getPreviousNode();
            if (nextNode == null) {
                path += " Start";
                break;
            }
            path += nextNode.getId() + " -> ";
            currentNode = nextNode;
        }

        System.out.println(path);
        System.out.println("=====================");
    }



    public static List<Node> createNodes() {
        Node node1 = new Node("1"); // start
        Node node2 = new Node("2"); // top
        Node node3 = new Node("3"); // center
        Node node4 = new Node("4"); // bottom-left
        Node node5 = new Node("5"); // bottom-right
        Node node6 = new Node("6"); // goal

        node1.addNode(node2, 1);
        node1.addNode(node3, 1);
        node1.addNode(node4, 1);

        node2.addNode(node1, 1);
        node2.addNode(node6, 1);
        node2.addNode(node3, 1);

        node3.addNode(node2, 1);
        node3.addNode(node1, 1);
        node3.addNode(node4, 1);
        node3.addNode(node5, 1);

        node4.addNode(node1, 1);
        node4.addNode(node3, 1);
        node4.addNode(node5, 1);

        node5.addNode(node4, 1);
        node5.addNode(node3, 1);
        node5.addNode(node6, 1);

        node6.addNode(node2, 1);
        node6.addNode(node5, 1);

        List<Node> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        nodes.add(node6);

        return nodes;
    }



}
