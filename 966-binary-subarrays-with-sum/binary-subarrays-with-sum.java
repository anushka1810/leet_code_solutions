class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // we have find number of subarray 
        // O(n^2)
        // int count=0;
        // for(int i=0;i<nums.length;i++){
        //     int sum=0;
        //     for(int j=i;j<nums.length;j++){
        //         // compute sumfor i-j--o(n^3)
        //         sum+=nums[j];
        //         if(sum==goal) count++;
        //     }
        // }
        // return count;

        // NEED TO COUNT OF SUBARRY WITH SUM=K
        HashMap<Integer,Integer> h=new HashMap<>();
        int sum=0;
        int count=0;
        h.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int target=sum-goal;
            if(h.containsKey(target)){
                count+=h.get(target);
            }

            h.put(sum,h.getOrDefault(sum,0)+1);
        }
        return count;
    }
}