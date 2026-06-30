class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int p:piles){
            pq.add(p);
        }

        while(k>0){
            int p=pq.poll();
            int val=(p+1)/2;
            pq.add(val);
            k--;
        }

        long sum=0;
        for(int p:pq){
            sum+=p;
        }
        return (int)sum;
    }
}