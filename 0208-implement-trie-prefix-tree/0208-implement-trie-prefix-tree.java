class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}
class Trie {
    TrieNode root;

    public Trie() {
        root =  new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            int i = c - 'a';

            if(node.children[i] == null) {
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;

        for(char c : word.toCharArray()) {
            int i = c - 'a';
            if(node.children[i] == null) return false;
            node = node.children[i];
        }

        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()) {
            int i = c - 'a';
            if(node.children[i] == null) return false;
            node = node.children[i];
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