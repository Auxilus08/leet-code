import java.util.*;

class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        
        List<Integer>[] charPositions = new List[26];
        for (int i = 0; i < 26; i++) {
            charPositions[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            charPositions[ring.charAt(i) - 'a'].add(i);
        }
        
        int[][] dp = new int[m][n];
        
        for (int idx : charPositions[key.charAt(0) - 'a']) {
            int dist = Math.abs(idx - 0);
            int rotate = Math.min(dist, n - dist);
            dp[0][idx] = rotate + 1;
        }
        
        for (int i = 1; i < m; i++) {
            char currChar = key.charAt(i);
            char prevChar = key.charAt(i - 1);
            
            for (int currIdx : charPositions[currChar - 'a']) {
                dp[i][currIdx] = Integer.MAX_VALUE;
                
                for (int prevIdx : charPositions[prevChar - 'a']) {
                    int dist = Math.abs(currIdx - prevIdx);
                    int rotate = Math.min(dist, n - dist);
                    
                    dp[i][currIdx] = Math.min(dp[i][currIdx], dp[i - 1][prevIdx] + rotate + 1);
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int idx : charPositions[key.charAt(m - 1) - 'a']) {
            result = Math.min(result, dp[m - 1][idx]);
        }
        
        return result;
    }
}