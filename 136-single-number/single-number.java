class Solution {
    public int singleNumber(int[] nums) {
        int c = 0;
        for(int num : nums){
            c = c ^ num;
        }


        return c;
    }
}