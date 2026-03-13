class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        for (int t : workerTimes) {
            pq.offer(new long[]{t, t, 1});
        }

        long maxTime = 0;
        for (int i = 0; i < mountainHeight; i++) {
            long[] curr = pq.poll();
            long totalTime = curr[0];
            long baseTime = curr[1];
            long multiplier = curr[2];
            maxTime = Math.max(maxTime, totalTime);
            long nextMultiplier = multiplier + 1;
            long nextTotalTime = totalTime + (baseTime * nextMultiplier);
            pq.offer(new long[]{nextTotalTime, baseTime, nextMultiplier});
        }

        return maxTime;
    }
}