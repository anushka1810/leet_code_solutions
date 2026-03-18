class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l=cardPoints.length;
        int k1=l-k;

        int i=0,j=0,sum=0,t=0;
        int min=Integer.MAX_VALUE;

        while(j<l){
            t+=cardPoints[j];
            sum+=cardPoints[j];
            if(j-i+1<k1) j++;
            else if(j-i+1==k1){
                min=Math.min(min,sum);
                sum-=cardPoints[i];
                i++;
                j++;
            }else{
                j++;
            }
        }
        if(k1==0) return t;
        return t-min;
    }
}