class Solution {
    public int minimumCost(int[] cost) {
        int[] freq = new int[101];

        for (int c : cost) {
            freq[c]++;
        }

        int count = 0;
        int sum = 0;

        for (int price = 100; price >= 1; price--) {
            while (freq[price]-- > 0) {
                count++;
                if (count % 3 != 0) {
                    sum += price;
                }
            }
        }

        return sum;
    }
}