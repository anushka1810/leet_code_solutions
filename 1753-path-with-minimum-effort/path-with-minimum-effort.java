class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int c=heights[0].length;
        int dist[][]=new int[n][c];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        int movement[][]={{1,0},{0,1},{-1,0},{0,-1}};

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(Integer.compare(a[2],b[2])));
        pq.add(new int[]{0,0,0});
        dist[0][0]=0;

        while(!pq.isEmpty()){
            int de[]=pq.poll();
            int i=de[0];
            int j=de[1];
            int distance=de[2];
            if(distance>dist[i][j]) continue;
            
            for(int mov[]:movement){
                int ni=mov[0]+i;
                int nj=mov[1]+j;

                if(ni>=0 && nj>=0 && ni<n && nj<c){
                    int weight=Math.abs(heights[ni][nj]-heights[i][j]);
                    int effort =Math.max(weight,distance);
                    if(effort<dist[ni][nj]){
                        dist[ni][nj]=effort;
                        pq.add(new int[]{ni,nj,dist[ni][nj]});
                    }
                }
            }
        }
        return dist[n-1][c-1];
    }
}