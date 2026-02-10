class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for(int i = 0; i < n; i++){
            if(n - i <= maxLen) break;

            int evenCount = 0;
            int oddCount = 0;

            HashSet<Integer> seen = new HashSet<>();
            for(int j = i; j < n; j++){
                if(seen.add(nums[j])){
                    if(nums[j] % 2 == 0) evenCount++;
                    else oddCount++;
                }


                if(evenCount == oddCount) maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
    }
}