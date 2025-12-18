class Solution {

    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int w : weights) {
            left = Math.max(left, w); 
            right += w;              
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int requiredDays = getNumOfDays(weights, mid);

            if (requiredDays <= days) {
                right = mid - 1; 
            } else {
                left = mid + 1;  
            }
        }

        return left;
    }

    private int getNumOfDays(int[] weights, int capacity) {
        int days = 1;
        int currentLoad = 0;

        for (int w : weights) {
            if (currentLoad + w > capacity) {
                days++;
                currentLoad = 0;
            }
            currentLoad += w;
        }

        return days;
    }
}
