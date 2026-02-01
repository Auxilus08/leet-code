class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int maxPoints = 1;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopes = new HashMap<>();
            int localMax = 0;

            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dy = y2 - y1;
                int dx = x2 - x1;

                int g = gcd(Math.abs(dy), Math.abs(dx));
                dy /= g;
                dx /= g;

                if (dx < 0) {
                    dy = -dy;
                    dx = -dx;
                } else if (dx == 0) {
                    dy = Math.abs(dy);
                }


                String key = dy + "/" + dx;
                slopes.put(key, slopes.getOrDefault(key, 0) + 1);
                
                localMax = Math.max(localMax, slopes.get(key));
            }

            maxPoints = Math.max(maxPoints, localMax + 1);
        }

        return maxPoints;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}