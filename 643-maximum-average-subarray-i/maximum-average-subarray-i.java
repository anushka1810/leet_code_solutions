class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;

        int i=0,j=0;
        int sum=0;
        double max=Integer.MIN_VALUE;

        while(j<n){
            sum+=nums[j];

            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                // max=(double)Math.max(max,sum/k);
                double val=(double)sum/k;

                if(val>max){
                    max=val;
                }

                sum-=nums[i];
                i++;
                j++;  
            }
        }
        return max;
    }
}