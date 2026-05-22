class Solution {
    public int characterReplacement(String s, int k) {
        int count[] = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for(int right=0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;

            maxFreq = Math.max(count[s.charAt(right) - 'A'], maxFreq);
            

            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(right - left + 1, maxLen);
            
        }
        return maxLen;   
    }
}