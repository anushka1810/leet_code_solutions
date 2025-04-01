class Solution {
    public int singleNonDuplicate(int[] nums){
        int n =0;
        for(int i : nums){
            n = n^i;
        }
        return n;
        
    }
}