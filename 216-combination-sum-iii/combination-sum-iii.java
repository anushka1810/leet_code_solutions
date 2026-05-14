class Solution {
    public void helper(int target,int k,int idx, List<List<Integer>> ans,List<Integer> path,int sum){
        if(path.size()==k){
            if(sum==target){
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        if(sum>target) return;
        if(idx==10) return;

        if(path.size()+(9-idx+1)<k) return;

        //not pick
        path.add(idx);
        helper(target,k,idx+1,ans,path,sum+idx);
        path.remove(path.size()-1);

        helper(target,k,idx+1,ans,path,sum);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();

        helper(n,k,1,ans,path,0);
        return ans;
    }
}