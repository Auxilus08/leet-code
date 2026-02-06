class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        
        for (int m = (int)(Math.log(num) / Math.log(2)); m >= 2; m--) {
            long left = 2, right = (long) Math.pow(num, 1.0 / m);
            
            while (left <= right) {
                long mid = left + (right - left) / 2;
                long sum = 0, p = 1;
                boolean overflow = false;
                
                for (int i = 0; i <= m; i++) {
                    sum += p;
                    if (i < m) {
                        if (p > num / mid) {
                            overflow = true;
                            break;
                        }
                        p *= mid;
                    }
                }
                
                if (!overflow && sum == num) {
                    return String.valueOf(mid);
                } else if (overflow || sum > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        
        return String.valueOf(num - 1);
    }
}