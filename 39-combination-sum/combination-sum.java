class Solution {
    public void solve(int[] nums,List<List<Integer>> ans,List<Integer> temp,int idx,int target){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(idx==nums.length){
            if(target==0) ans.add(new ArrayList<>(temp));
            return;
        }

        //pick
        if(nums[idx]<=target){
            temp.add(nums[idx]);
            solve(nums,ans,temp,idx,target-nums[idx]);
            temp.remove(temp.size()-1);    
        }

        //not pick
        solve(nums,ans,temp,idx+1,target);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(candidates,ans,temp,0,target);
        return ans;
    }
}