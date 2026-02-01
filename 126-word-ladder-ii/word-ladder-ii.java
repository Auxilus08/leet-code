class Solution {
    Map<String, Integer> distance = new HashMap<>();
    List<List<String>> results = new ArrayList<>();
    Set<String> dict;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return results;

        bfs(endWord, beginWord);

        if (!distance.containsKey(beginWord)) return results;

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, path);

        return results;
    }

    private void bfs(String start, String target) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.equals(target)) continue;

            int currDist = distance.get(curr);
            char[] chars = curr.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char original = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == original) continue;
                    chars[i] = c;
                    String neighbor = new String(chars);

                    if (dict.contains(neighbor) || neighbor.equals(target)) {
                        if (!distance.containsKey(neighbor)) {
                            distance.put(neighbor, currDist + 1);
                            queue.offer(neighbor);
                        }
                    }
                }
                chars[i] = original;
            }
        }
    }

    private void dfs(String curr, String endWord, List<String> path) {
        if (curr.equals(endWord)) {
            results.add(new ArrayList<>(path));
            return;
        }

        char[] chars = curr.toCharArray();
        int currDist = distance.get(curr);

        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == original) continue;
                chars[i] = c;
                String neighbor = new String(chars);

                if (distance.containsKey(neighbor) && distance.get(neighbor) == currDist - 1) {
                    path.add(neighbor);
                    dfs(neighbor, endWord, path);
                    path.remove(path.size() - 1);
                }
            }
            chars[i] = original;
        }
    }
}