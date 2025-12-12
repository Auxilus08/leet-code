class Solution {
    public int search(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        while(first <= last){
            int mid = first + (last - first) / 2;
            if(target > nums[mid]){
                first = mid + 1;
            }
            else if(target < nums[mid]){
                last = mid - 1;
            }
            else{
                return mid;
            }
        }

        return -1;
    }
}