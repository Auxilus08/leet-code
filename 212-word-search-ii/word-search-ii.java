class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> result) {
        char c = board[i][j];
        if (c == '#' || p.children[c - 'a'] == null) return;
        
        TrieNode nextNode = p.children[c - 'a'];
        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null;
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, nextNode, result);
        if (j > 0) dfs(board, i, j - 1, nextNode, result);
        if (i < board.length - 1) dfs(board, i + 1, j, nextNode, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, nextNode, result);
        
        board[i][j] = c; 
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (p.children[idx] == null) p.children[idx] = new TrieNode();
                p = p.children[idx];
            }
            p.word = w;
        }
        return root;
    }
}