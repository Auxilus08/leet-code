class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        if(nums.length == 0) return 0;
        for(int num : nums){
            set.add(num);
        }

        int best = 0;
        for(int num : set){
            if(!set.contains(num - 1)){
                int m = num + 1;
                while(set.contains(m)){
                    m++;
                }

                best = Math.max(best, m-num);
            }
        }

        return best;
    }
}

