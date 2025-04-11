class TrieNode {
    TrieNode[] children;
    String word;

    public TrieNode(){
        children = new TrieNode[26];
        word = null;
    }
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        Set<String> res= new HashSet<>();
        TrieNode root = buildTrie(words);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(i,j,root, board, res);
            }
        }
        return new ArrayList<String>(res);
    }
    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String w: words){
            TrieNode curr = root;
            for(char ch: w.toCharArray()){
                if(curr.children[ch-'a'] == null){
                    curr.children[ch-'a'] = new TrieNode();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.word = w;
        }
        return root;
    }
    private void dfs(int i, int j, TrieNode root, char[][] board, Set<String> res){
        if(i < 0 || i >=board.length || j < 0 || j >=board[0].length) return;
        char ch = board[i][j];
        if(ch == '#' || root.children[ch - 'a'] == null) return;
        root = root.children[ch - 'a'];
        if(root.word != null){
            res.add(root.word);
        }
        board[i][j] = '#';
        dfs(i+1, j, root, board, res);
        dfs(i-1, j, root, board, res);
        dfs(i, j+1, root, board, res);
        dfs(i, j-1, root, board, res);

        board[i][j] = ch;
    }
}