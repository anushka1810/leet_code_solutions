class Solution {
    // Easy to understand iske baad submiited answer is thora optimise 
    public int[] nse(int[] nums){
        int n=nums.length;
        int nse[]=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()) nse[i]=-1;
            else nse[i]=st.peek();
            st.push(i);
        }
        return nse;
    }
    public int[] pse(int[] nums){
        int n=nums.length;
        int pse[]=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()) pse[i]=-1;
            else pse[i]=st.peek();
            st.push(i);
        }

        return pse;
    }
    public int maxSumMinProduct(int[] nums) {
        int j=0;
        int n=nums.length;
        long ans=Long.MIN_VALUE;
        int MOD=1_000_000_007;
        int[] pse=pse(nums);
        int[] nse=nse(nums);
        long[] prefixSum=new long[n];
        prefixSum[0]=nums[0];
        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
    
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