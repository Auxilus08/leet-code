class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int value = map.getOrDefault(nums[i], 0);
            map.put(nums[i], value + 1);
        }

        for (Map.Entry<Integer, Integer> ent : map.entrySet()){
            if(ent.getValue() == 1){
                return ent.getKey();
            }
        }
        return -1;
    }
}