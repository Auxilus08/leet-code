class Solution {
    public int[][] merge(int[][] intervals) {
     Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));   
     LinkedList<int[]> LL = new LinkedList<>();

     for(int[] interval : intervals){
        if(LL.isEmpty() || LL.getLast()[1] < interval[0]){
            LL.add(interval);
        }
        else{
            LL.getLast()[1] = Math.max(LL.getLast()[1], interval[1]);
        }
     }

     return LL.toArray(new int[LL.size()][]);
    }
}