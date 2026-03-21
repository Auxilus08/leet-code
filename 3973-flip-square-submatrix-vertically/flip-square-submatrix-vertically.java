class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        

        for(int i = x, j = x + k - 1; i < j; i++, j--){
            for(int a = y; a < y + k; a++) {
                int temp = grid[i][a];
                grid[i][a] = grid[j][a];
                grid[j][a] = temp;
            }
        }

        return grid;
    }
}