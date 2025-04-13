class Solution {
    public int majorityElement(int[] nums) {
        return findMajority(nums,0,nums[0]);
    }
    public static int findMajority(int[] nums,int in,int va){
        int c=0;
        for(int i=in;i<nums.length;i++){
            if(nums[i]==va)
                c++;
            else {
                c--;
            }
            if(c==-1){
                return findMajority(nums,i,nums[i]);
            }
        }
        return va;
    }
}