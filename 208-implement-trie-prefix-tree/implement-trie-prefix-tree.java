class TrieNode{
    TrieNode[] children;
    boolean isEnd;

    TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
    }
}
class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;

        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = findone(word);
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = findone(prefix);
        return node != null;
    }
    private TrieNode findone(String str){
        TrieNode node = root;

        for(char ch : str.toCharArray()){
            int index = ch - 'a';
            if(node.children[index] == null){
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */