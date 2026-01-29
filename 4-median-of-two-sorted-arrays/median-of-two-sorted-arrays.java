class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // Ensure nums1 is the smaller array for binary search optimization
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int leftSize = (m + n + 1) / 2; // Size of the left half (handles odd/even)
        int low = 0;
        int high = m;
        
        while (low <= high) {
            int mid1 = (low + high) / 2; // Partition point in nums1
            int mid2 = leftSize - mid1;  // Corresponding partition in nums2
            
            // Left and right elements around the partitions
            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < m) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n) ? nums2[mid2] : Integer.MAX_VALUE;
            
            // Check if this is a valid partition
            if (l1 <= r2 && l2 <= r1) {
                // Found the correct partition
                if ((m + n) % 2 == 1) {
                    // Odd total: median is the max of left halves
                    return Math.max(l1, l2);
                } else {
                    // Even total: average of max left and min right
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else if (l1 > r2) {
                // Too many from nums1: move left
                high = mid1 - 1;
            } else {
                // Too few from nums1: move right
                low = mid1 + 1;
            }
        }

        return -1;
    }
}