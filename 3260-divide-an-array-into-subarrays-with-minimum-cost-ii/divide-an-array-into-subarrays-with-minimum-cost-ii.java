import java.util.TreeMap;

class Solution {
    private TreeMap<Integer, Integer> top = new TreeMap<>();
    private TreeMap<Integer, Integer> rest = new TreeMap<>();
    
    private long topSum = 0;
    private int topCount = 0;
    private int target; 

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        target = k - 1;
        
        long minSum = Long.MAX_VALUE;

        int i = 1;

        for (int j = 1; j < n; j++) {
            add(nums[j]);

            if (j - i > dist) {
                remove(nums[i]);
                i++;
            }

            if (topCount == target) {
                minSum = Math.min(minSum, topSum);
            }
        }
        return nums[0] + minSum;
    }

    private void add(int val) {
        if (topCount < target) {
            addToMap(top, val);
            topSum += val;
            topCount++;
        } else if (!top.isEmpty() && val < top.lastKey()) {
            int largestInTop = top.lastKey();
            removeFromMap(top, largestInTop);
            topSum -= largestInTop;
            addToMap(rest, largestInTop);
            
            addToMap(top, val);
            topSum += val;
        } else {
            addToMap(rest, val);
        }
    }
    
    private void remove(int val) {
        if (top.containsKey(val)) {
            removeFromMap(top, val);
            topSum -= val;
            topCount--;

            if (!rest.isEmpty()) {
                int smallestInRest = rest.firstKey();
                removeFromMap(rest, smallestInRest);
                addToMap(top, smallestInRest);
                topSum += smallestInRest;
                topCount++;
            }
        } else if (rest.containsKey(val)) {
            removeFromMap(rest, val);
        }
    }
    
    private void addToMap(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }
    
    private void removeFromMap(TreeMap<Integer, Integer> map, int val) {
        if (map.get(val) == 1) {
            map.remove(val);
        } else {
            map.put(val, map.get(val) - 1);
        }
    }
}