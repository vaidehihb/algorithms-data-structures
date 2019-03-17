package com.algo.ds.tree_graphs.binarytree;
import java.util.*;

class HuffmanNode implements Comparable<HuffmanNode>{
    private int freq;
    private char c;
    private HuffmanNode left;
    private HuffmanNode right;

    public HuffmanNode(int freq) {
        this.freq = freq;
        left = null;
        right = null;
        c = '-';
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        if(this.freq > o.freq) return 1;
        else if(this.freq < o.freq) return -1;
        return 0;
    }
}

public class HuffmanCoding {
    private HuffmanNode buildHuffmanTree(char[] chars, int[] freq){
        if(chars == null || freq == null || chars.length != freq.length) return null;
        Queue<HuffmanNode> queue = new PriorityQueue<>();
        for(int i=0; i<freq.length; i++){
            HuffmanNode h = new HuffmanNode(freq[i]);
            h.setC(chars[i]);
            queue.add(h);
        }
        HuffmanNode root = null;
        while (queue.size() > 1){
            HuffmanNode x = queue.poll();
            HuffmanNode y = queue.poll();
            if(x != null && y != null){
                root = new HuffmanNode(x.getFreq() + y.getFreq());
                root.setLeft(x);
                root.setRight(y);
                queue.add(root);
            }
        }
        return root;
    }

    private void mapHuffmanCodes(Map<Character, String> codes, HuffmanNode root, String code){
        if(root == null) return;
        if(root.getLeft() == null && root.getRight() == null && Character.isLetter(root.getC())){
            codes.put(root.getC(), code);
        }
        mapHuffmanCodes(codes, root.getLeft(), code + "0");
        mapHuffmanCodes(codes, root.getRight(), code + "1");
    }

    public Map<Character, String> getHuffmanCodes(int[] freq, char[] chars) {
        HuffmanNode root = buildHuffmanTree(chars, freq);
        if(root == null) return null;
        Map<Character, String> codes = new LinkedHashMap<>();
        mapHuffmanCodes(codes, root, "");
        return codes;
    }

}
