class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        long sum=0;

        for(int p:piles){
            sum+=p;
            pq.add(p);
        }

        while(k>0){
            int p=pq.poll();
            int val=(p+1)/2;
            sum=sum-p+val;
            pq.add(val);
            k--;
        }

        // for(int p:pq){
        //     sum+=p;
        // }
        return (int)sum;
    }
}