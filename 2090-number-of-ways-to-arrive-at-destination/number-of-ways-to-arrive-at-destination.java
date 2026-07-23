class Solution {
    public int countPaths(int n, int[][] roads) {
        long MOD=1000000007;
        long[] dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        long count[]=new long[n];
        ArrayList<ArrayList<int[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int road[]:roads){
            int u=road[0];
            int v=road[1];
            int w=road[2];

            graph.get(u).add(new int[]{v,w});
            graph.get(v).add(new int[]{u,w});
        }

        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b) -> Long.compare(a[1], b[1]));
        // node,distance
        pq.add(new long[]{0,0});
        dist[0]=0;
        count[0]=1;
        while(!pq.isEmpty()){
            long[] de=pq.poll();
            int node=(int)de[0];
            long distance=de[1];

            if(dist[node] <distance) continue;

            for(int neigh[]:graph.get(node)){
                int v=neigh[0];
                int weight=neigh[1];


                if(distance+weight<dist[v]){
                    count[v]=(count[node])%MOD;
                    dist[v]=distance+weight;
                    pq.add(new long[]{v,dist[v]});
                }else if(distance+weight==dist[v]){
                    count[v]=(count[v]+count[node])%MOD;
                }


            }


        }
        return (int)(count[n-1]%MOD);

    }
}