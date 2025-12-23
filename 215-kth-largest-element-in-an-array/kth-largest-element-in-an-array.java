import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> b - a); // max-heap

        for (int num : nums) {
            pq.offer(num);
        }

        for (int i = 1; i < k; i++) {
            pq.poll();
        }

        return pq.poll();
    }
}
