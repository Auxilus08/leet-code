class Solution {
    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        for (char c : hand.toCharArray()) handCount[c - 'A']++;
        java.util.Map<String, Integer> memo = new java.util.HashMap<>();
        int res = solve(board + "#", handCount, memo);
        return res >= 10 ? -1 : res;
    }

    private int solve(String board, int[] handCount, java.util.Map<String, Integer> memo) {
        board = collapse(board);
        if (board.equals("#")) return 0;

        String key = board + java.util.Arrays.toString(handCount);
        if (memo.containsKey(key)) return memo.get(key);

        int res = 10;

        for (int i = 0; i <= board.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (handCount[j] > 0) {
                    char c = (char) ('A' + j);
                    
                    boolean skip = true;
                    if (i > 0 && board.charAt(i - 1) == c) skip = false;
                    if (i < board.length() && board.charAt(i) == c) skip = false;
                    if (i > 0 && i < board.length() && board.charAt(i - 1) == board.charAt(i) && board.charAt(i) != c) skip = false;
                    
                    if (skip) continue;

                    handCount[j]--;
                    res = Math.min(res, 1 + solve(board.substring(0, i) + c + board.substring(i), handCount, memo));
                    handCount[j]++;
                }
            }
        }
        memo.put(key, res);
        return res;
    }

    private String collapse(String s) {
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(i) != s.charAt(j)) {
                if (j - i >= 3) return collapse(s.substring(0, i) + s.substring(j));
                i = j;
            }
        }
        return s;
    }
}