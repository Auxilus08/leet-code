class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        dict.remove(beginWord); 
        dict.remove(endWord); 

        int len = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();

            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        chars[i] = c;
                        String target = new String(chars);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (dict.contains(target)) {
                            nextSet.add(target);
                            dict.remove(target); 
                        }
                    }
                    chars[i] = original;
                }
            }
            beginSet = nextSet;
            len++;
        }

        return 0;
    }
}