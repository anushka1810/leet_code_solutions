class Solution {
    public void solve(int[] nums,List<List<Integer>> ans,List<Integer> temp,int idx){
        if(idx==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        //pick
        temp.add(nums[idx]);
        solve(nums,ans,temp,idx+1);
        temp.remove(temp.size()-1);

        //not pick
        //all occurence should be not pick 
        while(idx<nums.length-1 && nums[idx]==nums[idx+1]) idx++;
        solve(nums,ans,temp,idx+1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        Arrays.sort(nums);
        solve(nums,ans,temp,0);
        return ans;
    }
}