class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        int len=strs[0].length();

        int[]dp=new int[len];
        Arrays.fill(dp,1);

        int max=1;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                //check for i and j char for each string 
                boolean possible=true;
                for(int k=0;k<n;k++){
                    if(strs[k].charAt(i)<strs[k].charAt(j)){
                        // ans=1;
                        // dp[j]=Math.max(dp[j],1);
                        possible=false;
                        break;
                    }
                }

                if(possible){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }else{
                    dp[i]=Math.max(dp[i],1);
                }
            }
            if(dp[i]>max) max=dp[i];
        }

        return len-max;
    }
}