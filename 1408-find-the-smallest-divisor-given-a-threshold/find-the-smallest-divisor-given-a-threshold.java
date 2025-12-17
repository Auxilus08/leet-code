class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1, max = Arrays.stream(nums).max().getAsInt();
        int ans = -1;
        while(min <= max){
            int mid = min + (max - min) / 2;
            if(sumofDiv(nums, mid) <= threshold)
            {
                    ans = mid;
                 max = mid - 1;
            } 
            else{
            min = mid + 1;
            } 
        }

        return ans;
    }

    private int sumofDiv(int[] nums, int mid){
        int sum = 0;
        for(int n : nums){
            sum += (n + mid - 1) / mid;
        }


        return sum;
    }
}