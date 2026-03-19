class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] mat = new int[m][n];
        int[][] xCount = new int[m][n]; 
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 'X') {
                    mat[i][j] = 1;
                    xCount[i][j] = 1;
                }
                else if(grid[i][j] == 'Y') {
                    mat[i][j] = -1;
                }
                else {
                    mat[i][j] = 0; 
                }
            }
        }

        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int topMat = (i > 0) ? mat[i-1][j] : 0;
                int leftMat = (j > 0) ? mat[i][j-1] : 0;
                int topLeftMat = (i > 0 && j > 0) ? mat[i-1][j-1] : 0;
                
                mat[i][j] = mat[i][j] + topMat + leftMat - topLeftMat;
                int topX = (i > 0) ? xCount[i-1][j] : 0;
                int leftX = (j > 0) ? xCount[i][j-1] : 0;
                int topLeftX = (i > 0 && j > 0) ? xCount[i-1][j-1] : 0;
                
                xCount[i][j] = xCount[i][j] + topX + leftX - topLeftX;
                if(mat[i][j] == 0 && xCount[i][j] > 0) {
                    count++;
                } 
            }
        }

        return count;
    }
}