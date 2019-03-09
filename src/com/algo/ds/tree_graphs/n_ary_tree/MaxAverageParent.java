package com.algo.ds.tree_graphs.n_ary_tree;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxAverageParent {
    public int getMaxAverageParent(Node root){
        PriorityQueue<Node> pq = new PriorityQueue<>(10, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n2.compareTo(n1);
            }
        });
        helper(root, pq);
        return pq.peek().getValue();
    }

    private void helper(Node root, PriorityQueue<Node> pq){
        if(root == null || root.getChildren() == null || root.getChildren().isEmpty()) return;
        root.setParent(true);
        for (Node child: root.getChildren()) {
            helper(child, pq);
        }
        int sum = root.getSum();
        int count = root.getSubtreeCount();
        for (Node child: root.getChildren()){
            sum += child.getSum();
            count += child.getSubtreeCount();
        }
        root.setSum(sum);
        root.setSubtreeCount(count);
        pq.add(root);
    }

}
