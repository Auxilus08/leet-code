class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = 12345;
        
        int[][] p = new int[m][n];
        
        long[] left = new long[m * n + 1];
        left[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                left[idx + 1] = left[idx] * grid[i][j] % mod;
            }
        }
        
        long[] right = new long[m * n + 1];
        right[m * n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int idx = i * n + j;
                right[idx] = right[idx + 1] * grid[i][j] % mod;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                p[i][j] = (int) (left[idx] * right[idx + 1] % mod);
            }
        }
        
        return p;
    }
}