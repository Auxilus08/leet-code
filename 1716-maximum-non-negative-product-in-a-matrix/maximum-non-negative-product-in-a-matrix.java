class Solution {
    public int maxProductPath(int[][] grid) {
        long mod = 1_000_000_007;
        int m = grid.length;
        int n = grid[0].length;
        
        long[][] maxp = new long[m][n];
        long[][] minp = new long[m][n];
        maxp[0][0] = minp[0][0] = grid[0][0];

        for(int j = 1; j < n; j++) {
            maxp[0][j] = minp[0][j] = maxp[0][j-1] * grid[0][j];
        }

        for(int i = 1; i < m; i++) {
            maxp[i][0] = minp[i][0] = maxp[i-1][0] * grid[i][0];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                
                long current = grid[i][j];
                long maxPrev = Math.max(maxp[i-1][j], maxp[i][j-1]);
                long minPrev = Math.min(minp[i-1][j], minp[i][j-1]);

                if(current >= 0) {
                    maxp[i][j] = maxPrev * current;
                    minp[i][j] = minPrev * current;
                } else {
                    maxp[i][j] = minPrev * current;
                    minp[i][j] = maxPrev * current;
                }
            }
        }

        return (maxp[m-1][n-1] < 0) ? -1 : (int) (maxp[m-1][n-1] % mod); 
    }
}