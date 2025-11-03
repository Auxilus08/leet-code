class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int el = 0;
        int n = nums.length;

        for(int num: nums){
            if(count == 0){
                count = 1;
                el = num;
            }
            else if(el == num){
                count++;
            } 
            else {
                count--;
            }
        }

        return el;
    }
}