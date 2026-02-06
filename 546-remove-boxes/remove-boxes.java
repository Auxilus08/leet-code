class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] memo = new int[n][n][n];
        return calculate(boxes, 0, n - 1, 0, memo);
    }

    private int calculate(int[] boxes, int i, int j, int k, int[][][] memo) {
        if (i > j) return 0;
        if (memo[i][j][k] > 0) return memo[i][j][k];

        int i0 = i, k0 = k;
        while (i + 1 <= j && boxes[i + 1] == boxes[i]) {
            i++;
            k++;
        }

        int res = (k + 1) * (k + 1) + calculate(boxes, i + 1, j, 0, memo);

        for (int m = i + 1; m <= j; m++) {
            if (boxes[m] == boxes[i]) {
                res = Math.max(res, calculate(boxes, i + 1, m - 1, 0, memo) + calculate(boxes, m, j, k + 1, memo));
            }
        }

        memo[i0][j][k0] = res;
        return res;
    }
}