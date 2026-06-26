class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {

        // Xj>Xi so |Xi-Xj|==-(Xi-Xj)==>|Xi-Xj|==Xj-Xi
        // toh eq=Yi+Yj+Xj-Xi===>(Yi-Xi)+(Xi+Xj)
        // toh for current index (Xi+Xj) is fixed only we need to maximise (Yi-Xi)
        // toh pq me prev pt ko stire krege pr kis form me y-x ke according sort krke 
        // but ek condition hume aur dekhni pdegi ki |Xi-Xj|<=k hona chahiye 
        // uske liye prev pt ka x cordinate bhi chahiye hoga 
        // toh hum pq usse bhi store  krege 
        // ab har j pt ke xi+xj calculate kre phir hum xi+yi ka maximum value pq se nikale 
        // lekin agr pq.peek() me prev pt ka x cordinate hai aur current pt ka x cordinate hai toh toh condition phle check kro agr condition satisfy nhi hui toh uske baad ke pt ke liye bhi nhi hogi kyu unka x cordinate toh bda hoga curr se kyuki x cordinate sorted hai toh that means uss pt ka ab koi kamm nhi remove that pt 
        // and if pq.me koi element bacha remove krne ke baad toh that pt will contribute a pair 
        // and  since we have to track the maximum toh uske nicghe uss pt ke liye check krne ki jaruirat nhi hai 
        
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