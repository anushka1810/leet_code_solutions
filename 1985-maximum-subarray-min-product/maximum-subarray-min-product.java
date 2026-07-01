class Solution {
    public int maxSumMinProduct(int[] nums) {


        int n=nums.length;
        int nse[]=new int[n];
        Stack<Integer> st=new Stack<>();

        int pse[]=new int[n];
        Stack<Integer> st2=new Stack<>();

        long[] prefixSum=new long[n];
        long sum=0;

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()) nse[i]=-1;
            else nse[i]=st.peek();
            st.push(i);

            int j=n-1-i;
            while(!st2.isEmpty() && nums[st2.peek()]>=nums[j]){
                st2.pop();
            }
            if(st2.isEmpty()) pse[j]=-1;
            else pse[j]=st2.peek();
            st2.push(j);
            
            prefixSum[j]=sum+nums[j];
            sum=prefixSum[j];
        }


        int j=0;
        long ans=Long.MIN_VALUE;
        int MOD=1_000_000_007;
    
        while(j<n){
            long l=(pse[j]==-1)?0:prefixSum[pse[j]];
            long r=(nse[j]==-1)?prefixSum[n-1]:prefixSum[nse[j]-1];
            long subarraysum=r-l;
            long min_product=subarraysum*nums[j];
            if(min_product>ans) ans=min_product;
            j++;
        }
        return (int)(ans%MOD);
    }
}