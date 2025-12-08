class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if(numRows == 0){
            return res;
        }

        for(int i = 0; i < numRows; i++){
            List<Integer> currentRow = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                currentRow.add(nCr(i,j));
            }
        res.add(currentRow);
        }

        return res;
    }




    private int nCr(int n, int r){
        if(r > n - r){
            r = n - r;
        }
        long res = 1;
        for(int i = 0; i < r; i++){
            res = res * (n - i);
            res = res / (i + 1);
        }

        return (int) res;
    }
}