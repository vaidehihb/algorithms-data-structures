package com.algo.ds.data_structures;

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode current = root;
        for(char c:word.toCharArray()){
            TrieNode node = current.getChildren().get(c);
            if(node == null){
                node = new TrieNode();
                current.getChildren().put(c,node);
            }
            current = node;
        }
        current.setEndOfWord(true);
    }

    public void insertRec(String word){
        insertRec(root, word, 0);
    }

    private void insertRec(TrieNode current, String word, int index){
        if(word.length() == index){
            current.setEndOfWord(true);
            return;
        }
        TrieNode node = current.getChildren().get(word.charAt(index));
        if(node == null){
            node = new TrieNode();
            current.getChildren().put(word.charAt(index), node);
        }
        insertRec(node, word, index+1);
    }

    public boolean search(String word){
        TrieNode current = root;
        for (int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if(node == null) return false;
            current = node;
        }
        return current.isEndOfWord();
    }

    public boolean searchRec(String word){
        return searchRec(root, word, 0);
    }

    private boolean searchRec(TrieNode current, String word, int index){
        if(index == word.length()) return current.isEndOfWord();
        TrieNode node = current.getChildren().get(word.charAt(index));
        if(node == null) return false;
        return searchRec(node, word, index+1);
    }

    public void delete(String word){
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index){
        if(index == word.length()){
            if(!current.isEndOfWord()) return false;
            current.setEndOfWord(false);
            return current.getChildren().size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if(node == null) return false;
        if(delete(node, word, index+1)){
            current.getChildren().remove(ch);
            return current.getChildren().size() == 0;
        }
        return false;
    }
}
