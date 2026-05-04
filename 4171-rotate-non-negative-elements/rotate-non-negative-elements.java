class Solution {
    public int[] rotateElements(int[] nums, int k) {
        // brute force 
        // queue me +ve number daalo rotate kro k step 
        // phir array ke non negative wali jgh pr add kr do 
        // queue-n space
        // travese +ve ->O(N)
        // push--k
        // traverse-o(N)

        if(nums.length==1) return nums;
        Deque<Integer> q=new ArrayDeque<>();
        for(int num:nums){
            if(num>=0) q.addLast(num);
        }
        if(q.size()==0) return nums;
        
        while(k>0){
            q.addLast(q.pollFirst());
            k--;
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                nums[i]=q.pollFirst();
            }
        }

        return nums;




    }
}