class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(nums[b], nums[a]));
        int ans[] = new int[nums.length-k+1];
        for(int i=0, idx=0; i<nums.length; i++){
            pq.add(i);
            if(i >= (k-1)){
                while(pq.peek() <= i-k) pq.poll();
                ans[idx++] = nums[pq.peek()];
            }
        }
        return ans;
    }
}