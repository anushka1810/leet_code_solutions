class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int r=triangle.size();
        if(r==0) return 0;
        int c=triangle.get(r-1).size();
        if(c==1){
            int sum=0;
            for(int i=0;i<r;i++){
                sum+=triangle.get(i).get(0);
            }
            return sum;
        }

        int[] dp=new int[c];
        Arrays.fill(dp,Integer.MAX_VALUE);

        for(int i=0;i<triangle.get(0).size();i++){
            dp[i]=triangle.get(0).get(i);
        }

        for(int i=1;i<r;i++){
            int last=dp[0];
            dp[0]=dp[0]+triangle.get(i).get(0);
            for(int j=1;j<triangle.get(i).size();j++){
                int temp=dp[j];
                if(dp[j]==Integer.MAX_VALUE){
                    dp[j]=last+triangle.get(i).get(j);
                }else{
                    dp[j]=Math.min(dp[j]+triangle.get(i).get(j),triangle.get(i).get(j)+last);
                }
                last=temp;
            }
        }

        int min=Integer.MAX_VALUE;
        for(int num:dp){
            if(num<min){
                min=num;
            }
        }
        return min;


    }
}