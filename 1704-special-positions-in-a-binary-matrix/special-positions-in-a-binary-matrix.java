class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] row = new int[n];
        int[] column = new int[m];

        for(int i = 0; i < n; i++) {
            for(int j =0; j < m; j++){
                if(mat[i][j] == 1) {
                    row[i]++;
                    column[j]++;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 1 && row[i] == 1 && column[j] == 1){
                    ans++;
                }
            }
        }



        return ans;
    }
}