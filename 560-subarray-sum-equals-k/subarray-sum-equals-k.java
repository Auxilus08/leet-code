class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int currSum = 0;
        int ans = 0;
        int n = nums.length;

        for(int j=0; j<n; j++){
            currSum+=nums[j];
            int reqSum = currSum - k;

            if(prefixSum.containsKey(reqSum)){
                ans+=prefixSum.get(reqSum);
            }
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        }
        return ans;
    }
}