class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1; // The smallest number we cannot currently form
        int patches = 0;
        int i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                // If the current number in the array can help cover 'miss'
                miss += nums[i];
                i++;
            } else {
                // We must patch the array with 'miss' to extend our reach furthest
                miss += miss;
                patches++;
            }
        }

        return patches;
    }
}
