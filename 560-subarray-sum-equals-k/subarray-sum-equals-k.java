class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> h=new HashMap<>();
        int j=0,ans=0,sum=0;
        h.put(0,1);

        while(j<nums.length){
            sum+=nums[j];
            int target=sum-k;
            if(h.containsKey(target)){
                ans+=h.get(target);
            }
            h.put(sum,h.getOrDefault(sum,0)+1);
            j++;
        }
        return ans;
    }
}