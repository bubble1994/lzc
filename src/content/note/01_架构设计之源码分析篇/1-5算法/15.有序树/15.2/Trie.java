class TrieNode {
    //a - z
    char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean hasWord;
    public TrieNode() {
    
    }
    public TrieNode(char c) {
        this.c = c;
    }
    
}
public class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        HashMap<Character, TrieNode> children = current.children;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            char wc = wordArray[i];
            if (!children.containsKey(wc)) {
                TrieNode newNode = new TrieNode(wc);
                children.put(wc, newNode);
                current = newNode;
            } else {
                current = children.get(wc);
            }
            children = current.children;
            if (i == wordArray.length - 1) {
                current.hasWord = true;
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode current = null;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            if (children.containsKey(wordArray[i])) {
                current = children.get(wordArray[i]);
                children = current.children;
            } else {
                return false;
            }
        }
        if (current.hasWord){
            return true;    
        } else {
            return false;
        }
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode current = null;
        char[] wordChar = prefix.toCharArray();
        for (int i = 0; i < wordChar.length; i++) {
            if (children.containsKey(wordChar[i])) {
                current = children.get(wordChar[i]);
                children = current.children;
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */