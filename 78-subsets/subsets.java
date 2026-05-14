class Solution {
    public void helper(int nums[],int idx, List<List<Integer>> ans,List<Integer> path){
        if(idx==nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }

        //not pick
        path.add(nums[idx]);
        helper(nums,idx+1,ans,path);
        path.remove(path.size()-1);

        helper(nums,idx+1,ans,path);
    }
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();

        helper(nums,0,ans,path);
        return ans;
    }
}