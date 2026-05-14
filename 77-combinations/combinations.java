class Solution {
    public void helper(int n,int k,int idx, List<List<Integer>> ans,List<Integer> path){
        if(path.size()==k){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(idx==n+1){
            return;
        }

        if(n-idx+1+path.size()<k)  return ;

        // pick
        path.add(idx);
        helper(n,k,idx+1,ans,path);
        path.remove(path.size()-1);

        helper(n,k,idx+1,ans,path);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();

        helper(n,k,1,ans,path);
        return ans;
    }
}