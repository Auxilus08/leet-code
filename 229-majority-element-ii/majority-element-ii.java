class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> res =  new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            res.put(nums[i], res.getOrDefault(nums[i], 0) + 1);
        }   

        List<Integer> majority = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : res.entrySet()){
            int ele = entry.getKey();
            int count = entry.getValue();

            if(count > nums.length / 3){
                majority.add(ele);
            }
        }

        return majority;
    }
}