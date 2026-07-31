class Solution {
    public boolean solve(int[] nums,int k,int reqSum,boolean[] visited,int sum,int idx){
        if(k==1) return true;
        if(sum==reqSum){
            return solve(nums,k-1,reqSum,visited,0,0);
        }
        if(sum>reqSum) return false;
        if(idx>=nums.length) return false;
        if(nums[idx]>reqSum) return false;

        // if(dp[idx][sum][k]!=null) return dp[idx][sum][k];


        boolean op1=false ,op2=false;
        if(!visited[idx]){
            visited[idx]=true;
            op1=solve(nums,k,reqSum,visited,sum+nums[idx],idx+1);
            if(op1) return true;
            visited[idx]=false;
        }
        op2=solve(nums,k,reqSum,visited,sum,idx+1);

        return op1||op2;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {

        Arrays.sort(nums);
        // reverse(nums);

        for(int i=0;i<nums.length/2;i++){
            int temp=nums[nums.length-1-i];
            nums[nums.length-1-i]=nums[i];
            nums[i]=temp;

        }

        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        if(totalSum%k!=0) return false;

        boolean visited[]=new boolean[nums.length];

        int reqSum=totalSum/k;


        // Boolean dp[][][]=new Boolean[nums.length+1][totalSum+1][k+1];
        // // for(int )

        return solve(nums,k,totalSum/k,visited,0,0);
    }
}