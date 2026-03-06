class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int i=0;
        while(i < n && s.charAt(i) == '1') i++;
        if(i == n) return true;
        int j = n-1;
        while(s.charAt(j) == '0') j--;
        return i>j;
    }
}