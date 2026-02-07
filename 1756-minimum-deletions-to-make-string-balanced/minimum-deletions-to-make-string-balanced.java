class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        int res=0;
        int count=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='b')count++;
            else if(count!=0){
                res++;
                count--;
            }
        }
        // int ans=n;
        // int count=0;
        // int[] pre=new int[n];
        // for(int i=0;i<n;i++){
            // if(s.charAt(i)=='a')count++;
            // pre[i]=count;
        // }
        // count=0;
        // for(int i=n-1;i>=0;i--){
            // if(s.charAt(i)=='b')count++;
            // ans=Math.min(ans,count+pre[i]);
        // }
        return res;
    }
}