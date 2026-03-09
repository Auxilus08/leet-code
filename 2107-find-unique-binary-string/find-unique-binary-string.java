class Solution {
    public String findDifferentBinaryString(String[] nums) {
       StringBuilder sb = new StringBuilder();
        int ans =0;
        int i=0;
        for(String num:nums) {
            if(num.charAt(i++)=='1') {
                sb.append('0');
            }
                else
                sb.append('1');
            
        }
        return sb.toString();
    }
}