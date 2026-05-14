class Solution {
    public void solve(int[] candidates, int target,List<List<Integer>> ans,int idx,List<Integer> path){
        if(target==0){
            ans.add(new ArrayList<>(path));
            return ;
        }
        if(idx==candidates.length || target<0) return;
        if(candidates[idx]<=target){
            path.add(candidates[idx]);
            solve(candidates,target-candidates[idx],ans,idx,path);
            path.remove(path.size()-1);
        }
        solve(candidates,target,ans,idx+1,path);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();

        solve(candidates,target,ans,0,path);
        return ans;
    }
}