class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        for(int i = 0; i < cost.length; i++) {
            if(i % 3 == 2) continue;
            sum += cost[cost.length - i - 1];
        }


        return sum;
    }
}