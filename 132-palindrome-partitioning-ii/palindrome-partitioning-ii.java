class Solution {
    public int minCut(String s) {
        int n = s.length();
        if (n <= 1) return 0;

        boolean[][] isPal = new boolean[n][n];
        int[] cuts = new int[n];

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;

                    min = (j == 0) ? 0 : Math.min(min, cuts[j - 1] + 1);
                }
            }
            cuts[i] = min;
        }

        return cuts[n - 1];
    }
}