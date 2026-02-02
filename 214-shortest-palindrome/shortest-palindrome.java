class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        String temp = s + "#" + rev;
        int[] lps = new int[temp.length()];
        for (int i = 1; i < temp.length(); i++) {
            int j = lps[i - 1];
            
            while (j > 0 && temp.charAt(i) != temp.charAt(j)) {
                j = lps[j - 1];
            }
            
            if (temp.charAt(i) == temp.charAt(j)) {
                j++;
            }
            
            lps[i] = j;
        }
        
        int longestPalindromicPrefixLen = lps[temp.length() - 1];
        
        return rev.substring(0, s.length() - longestPalindromicPrefixLen) + s;
    }
}