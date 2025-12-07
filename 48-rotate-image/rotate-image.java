class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int temp;
        
        for(int i = 0; i < m; i++){
            for(int j = i + 1; j < m; j++){
                temp =  matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int start;
        int end;
        for( int i = 0; i < m; i++){
            start = 0;
            end = m - 1;

            while(start < end && start < m && end < m){
                temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;

                start++;
                end--;
            }
        }
    }
}