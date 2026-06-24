class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> dq= new ArrayDeque<>();
        int ans[]=new int[nums.length-k+1];
        int idx=0;

        int i=0,j=0;
        while(j<nums.length){
            while(!dq.isEmpty() && dq.peekLast()<nums[j]){
                dq.pollLast();
            }
            dq.addLast(nums[j]);

            if(j-i+1==k){
                ans[idx++]=dq.peek();
                if(nums[i]==dq.peek()){
                    dq.pollFirst();
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}