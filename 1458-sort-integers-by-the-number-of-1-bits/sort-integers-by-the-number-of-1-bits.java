class Solution {
    public int[] sortByBits(int[] arr) {
        int[][] buckets = new int[32][];
        int[] sizes = new int[32];

        for (int num : arr) {
            sizes[Integer.bitCount(num)]++;
        }

        for (int i = 0; i < 32; i++) {
            buckets[i] = new int[sizes[i]];
        }

        Arrays.fill(sizes, 0);

        for (int num : arr) {
            int bits = Integer.bitCount(num);
            buckets[bits][sizes[bits]++] = num;
        }

        int index = 0;
        for (int i = 0; i < 32; i++) {
            if (buckets[i].length > 0) {
                Arrays.sort(buckets[i]);
                for (int num : buckets[i]) {
                    arr[index++] = num;
                }
            }
        }

        return arr;
    }
}