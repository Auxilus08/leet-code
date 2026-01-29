class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return result;
        }
        int n = s.length();
        int numWords = words.length;
        int wordLen = words[0].length();
        int totalLen = numWords * wordLen;
        if (n < totalLen) {
            return result;
        }
        
        // Assume all words have the same length; in production, add checks
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // For each possible offset (0 to wordLen - 1)
        for (int offset = 0; offset < wordLen; offset++) {
            Map<String, Integer> seen = new HashMap<>();
            int count = 0; // Number of valid words in current window
            int left = offset;
            
            for (int j = offset; j <= n - wordLen; j += wordLen) {
                String currWord = s.substring(j, j + wordLen);
                
                if (wordCount.containsKey(currWord)) {
                    seen.put(currWord, seen.getOrDefault(currWord, 0) + 1);
                    count++;
                    
                    // Shrink from left if too many occurrences
                    while (seen.get(currWord) > wordCount.getOrDefault(currWord, 0)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        if (seen.get(leftWord) == 0) {
                            seen.remove(leftWord);
                        }
                        count--;
                        left += wordLen;
                    }
                    
                    // Check if we have a full match
                    if (count == numWords) {
                        result.add(left);
                        // Slide the window forward by removing the leftmost word
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        if (seen.get(leftWord) == 0) {
                            seen.remove(leftWord);
                        }
                        count--;
                        left += wordLen;
                    }
                } else {
                    // Invalid word: reset the window
                    seen.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }
        
        return result;
    }
}