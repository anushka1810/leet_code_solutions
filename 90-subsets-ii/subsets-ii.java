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

        while(idx+1<nums.length && nums[idx+1]==nums[idx]) idx++;
        helper(nums,idx+1,ans,path);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();

        helper(nums,0,ans,path);
        return ans;
    }
}
