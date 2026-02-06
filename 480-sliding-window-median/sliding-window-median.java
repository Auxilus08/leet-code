class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        java.util.PriorityQueue<Integer> left = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
        java.util.PriorityQueue<Integer> right = new java.util.PriorityQueue<>();
        java.util.Map<Integer, Integer> lazy = new java.util.HashMap<>();
        
        int i = 0;
        for (; i < k; i++) left.add(nums[i]);
        for (int j = 0; j < k / 2; j++) right.add(left.poll());
        
        result[0] = getMedian(left, right, k);
        
        for (; i < nums.length; i++) {
            int outNum = nums[i - k];
            int inNum = nums[i];
            int balance = 0;
            
            balance += (outNum <= left.peek() ? -1 : 1);
            lazy.put(outNum, lazy.getOrDefault(outNum, 0) + 1);
            
            if (!left.isEmpty() && inNum <= left.peek()) {
                balance++;
                left.add(inNum);
            } else {
                balance--;
                right.add(inNum);
            }
            
            if (balance < 0) {
                left.add(right.poll());
            } else if (balance > 0) {
                right.add(left.poll());
            }
            
            while (!left.isEmpty() && lazy.getOrDefault(left.peek(), 0) > 0) {
                lazy.put(left.peek(), lazy.get(left.peek()) - 1);
                left.poll();
            }
            while (!right.isEmpty() && lazy.getOrDefault(right.peek(), 0) > 0) {
                lazy.put(right.peek(), lazy.get(right.peek()) - 1);
                right.poll();
            }
            
            result[i - k + 1] = getMedian(left, right, k);
        }
        
        return result;
    }
    
    private double getMedian(java.util.PriorityQueue<Integer> left, java.util.PriorityQueue<Integer> right, int k) {
        if (k % 2 == 1) return (double) left.peek();
        return ((double) left.peek() + right.peek()) / 2.0;
    }
}