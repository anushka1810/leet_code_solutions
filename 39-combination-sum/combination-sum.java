class Solution {
    // public void solve(int[] candidates, int target,List<List<Integer>> ans,int idx,int sum,List<Integer> path){
    //     int size=path.size();
    //     if(idx==candidates.length) return;
    //     sum+=candidates[idx];
    //     path.add(candidates[idx]);
    //     if(sum==target){
    //         ans.add(path);
    //     }else if(sum<target){
    //         solve(candidates,target,ans,idx,sum,path);
    //     }
    //     path.remove(size);
    // }
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     List<List<Integer>> ans=new ArrayList<>();
    //     List<Integer> path=new ArrayList<>();

    //     solve(candidates,target,ans,0,0,path);
    //     return ans;
    // }

    public void solve(int[] candidates, int target,List<List<Integer>> ans,int idx,List<Integer> path){
        if(idx==candidates.length || target<0) return;
        if(target==0){
            ans.add(new ArrayList<>(path));
            return ;
        }else if(candidates[idx]<=target){
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