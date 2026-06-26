class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {

        // Xj>Xi so |Xi-Xj|==-(Xi-Xj)==>|Xi-Xj|==Xj-Xi
        // toh eq=Yi+Yj+Xj-Xi===>(Yi-Xi)+(Xi+Xj)
        // toh for current index (Xi+Xj) is fixed only we need to maximise (Yi-Xi)
        // toh pq me prev pt ko stire krege pr kis form me y-x ke according sort krke 
        // but ek condition hume aur dekhni pdegi ki |Xi-Xj|<=k hona chahiye 
        // uske liye prev pt ka x cordinate bhi chahiye hoga 
        // toh hum pq usse bhi store  krege 
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        int max=Integer.MIN_VALUE;

        for(int pt[]:points){
            int x=pt[0];
            int y=pt[1];

            int currsum=x+y;
            while(!pq.isEmpty() && x-pq.peek()[1]>k) pq.poll();

            if(!pq.isEmpty()){
                int value= currsum+pq.peek()[0];
                if(value>max) max=value;
            }
            pq.add(new int[]{y-x,x});
        }
        return max;


        
    }
}