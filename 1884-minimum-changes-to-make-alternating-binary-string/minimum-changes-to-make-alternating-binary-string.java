class Solution {
    public int minOperations(String s) {    
        int count = 0;
        int start = 0;

        for(char c : s.toCharArray()) {
            if((c - '0') != start) count++;
            start ^= 1;
        }

        return Math.min(count, s.length() - count);
    }
}