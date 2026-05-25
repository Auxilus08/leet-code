class Solution {
    public int trailingZeroes(int n) {
        int sum = 0;
        while(n > 0) {
            n /= 5;
            sum+= n;
            if(n < 5) break;
            
        }

        return sum;
    }
}