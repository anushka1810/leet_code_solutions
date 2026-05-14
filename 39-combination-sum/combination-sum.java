class Solution {
    public void solve(int[] candidates,int sum, int target,List<List<Integer>> ans,int idx,List<Integer> path){
        if(sum==target){
            ans.add(new ArrayList<>(path));
            return ;
        }
        if(idx==candidates.length|| sum>target) return;
        path.add(candidates[idx]);
        solve(candidates,sum+candidates[idx],target,ans,idx,path);
        path.remove(path.size()-1);
        // if(candidates[idx]+sum<=target){
        //     path.add(candidates[idx]);
        //     solve(candidates,sum+candidates[idx],target,ans,idx,path);
        //     path.remove(path.size()-1);
        // }
        solve(candidates,sum,target,ans,idx+1,path);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();

        solve(candidates,0,target,ans,0,path);
        return ans;
    }
}