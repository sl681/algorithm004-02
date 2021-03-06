/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (61.75%)
 * Likes:    148
 * Dislikes: 0
 * Total Accepted:    16.7K
 * Total Submissions: 26.7K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 
 * 示例:
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");   
 * trie.search("app");     // 返回 true
 * 
 * 说明:
 * 
 * 
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 
 * 
 */

// @lc code=start

class TrieNode{
    private TrieNode[] links;

    private final int R=26;
    
    private boolean isEnd;

    public TrieNode() {
        links=new TrieNode[R];
    }  

    public boolean containsKey(char c) {
        return links[c-'a'] !=null;
    }
    
    public TrieNode get(char c) {
        return links[c-'a'];
    }

    public void put(char c,TrieNode node) {
        links[c-'a']=node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node=root;
        for (int i=0;i<word.length();i++) {
            char cn=word.charAt(i);
            if(!node.containsKey(cn)){
                node.put(cn,new TrieNode());
            }
            node=node.get(cn);
        } 
        node.setEnd();
    }
    


    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node=root;
        for (int i=0;i<word.length();i++) {
            char cn=word.charAt(i);
            if(node.containsKey(cn)){
                node=node.get(cn);
            }else{
                return false;
            }
        } 
        return node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node=root;
        for (int i=0;i<prefix.length();i++) {
            char cn=prefix.charAt(i);
            if(node.containsKey(cn)){
                node=node.get(cn);
            }else{
                return false;
            }
        } 
        return node !=null ;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

