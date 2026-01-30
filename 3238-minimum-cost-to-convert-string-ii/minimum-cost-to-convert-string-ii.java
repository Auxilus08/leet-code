
class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = source.length();
        Map<String, Integer> strToId = new HashMap<>();
        Set<Integer> lengths = new HashSet<>();
        
        for (String s : original) {
            if (!strToId.containsKey(s)) strToId.put(s, strToId.size());
            lengths.add(s.length());
        }
        for (String s : changed) {
            if (!strToId.containsKey(s)) strToId.put(s, strToId.size());
            lengths.add(s.length());
        }

        int numIds = strToId.size();
        long[][] dist = new long[numIds][numIds];
        for (long[] row : dist) Arrays.fill(row, Long.MAX_VALUE / 2);
        for (int i = 0; i < numIds; i++) dist[i][i] = 0;
        for (int i = 0; i < original.length; i++) {
            int u = strToId.get(original[i]);
            int v = strToId.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], (long) cost[i]);
        }

        for (int k = 0; k < numIds; k++) {
            for (int i = 0; i < numIds; i++) {
                if (dist[i][k] == Long.MAX_VALUE / 2) continue;
                for (int j = 0; j < numIds; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE / 2);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == Long.MAX_VALUE / 2) continue;

            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            for (int len : lengths) {
                if (i + len <= n) {
                    String subS = source.substring(i, i + len);
                    String subT = target.substring(i, i + len);
                    
                    if (strToId.containsKey(subS) && strToId.containsKey(subT)) {
                        int u = strToId.get(subS);
                        int v = strToId.get(subT);
                        if (dist[u][v] < Long.MAX_VALUE / 2) {
                            dp[i + len] = Math.min(dp[i + len], dp[i] + dist[u][v]);
                        }
                    }
                }
            }
        }

        return dp[n] >= Long.MAX_VALUE / 2 ? -1 : dp[n];
    }
}