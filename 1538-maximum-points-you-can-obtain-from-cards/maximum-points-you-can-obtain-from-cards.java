class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int total=0;
        if(k==n){
            for(int num:cardPoints){
                total+=num;
            }
            return total;
        }
        int i=0,j=0;
        int k1=n-k;
        // boolean flag=false;
        int min=Integer.MAX_VALUE;
        int sum=0;


        while(j<n){
            // if(j==k-1) flag=true;
            total+=cardPoints[j];
            sum+=cardPoints[j];

            if(j-i+1<k1) j++;
            else if(j-i+1==k1){
                if(sum<min) min=sum;
                sum-=cardPoints[i];
                i++;
                j++;
            }
            // if(j==n) j=0;
        }
        System.out.println(total);
        return total-min;
    }
}