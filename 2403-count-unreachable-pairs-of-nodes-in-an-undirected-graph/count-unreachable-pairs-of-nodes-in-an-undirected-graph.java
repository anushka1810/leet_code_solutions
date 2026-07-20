class Solution {
    class DSU{
        int v;
        int parent[];
        int size[];
        int rank[];

        DSU(int v){
            this.v=v;
            this.parent=new int[v];
            this.size=new int[v];
            this.rank=new int[v];

            for(int i=0;i<v;i++){
                this.parent[i]=i;
                this.size[i]=1;
                this.rank[i]=0;
            }
        }


        public int findParent(int x){
            if(parent[x]==x){
                return x;
            }
            return parent[x]=findParent(parent[x]);
        }

        public void unionByrank(int x,int y){
            int parentX=findParent(x);
            int parentY=findParent(y);

            if(parentX==parentY) return;

            if(rank[parentX]==rank[parentY]){
                parent[parentY]=parentX;
                rank[parentX]++;
            }else if(rank[parentX]>rank[parentY]){
                parent[parentY]=parentX;
            }else{
                parent[parentX]=parentY;
            }
        }
        public void unionBySize(int x,int y){
            int parentX=findParent(x);
            int parentY=findParent(y);

            if(parentX==parentY) return;
            if(size[parentX]>=size[parentY]){
                parent[parentY]=parentX;
                size[parentX]+=size[parentY];
            }else{
                parent[parentX]=parentY;
                size[parentY]+=size[parentX];
            }
        }
    }
    public long countPairs(int n, int[][] edges) {

        // List<List<Integer>> graph=new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     graph.add(new ArrayList<>());
        // }

        // for(int[] edge:edges){
        //     graph.get(edge[0]).add(edge[1]);
        //     graph.get(edge[1]).add(edge[0]);
        // }

        // Queue<Integer> q=new LinkedList<>();
        // boolean visited[]=new boolean[n];
        // long left=n;
        // long ans=0;


        // for(int i=0;i<n;i++){
        //     if(!visited[i]){
        //         q.add(i);
        //         visited[i]=true;
        //         long covered=0;
        //         while(!q.isEmpty()){
        //             int node=q.poll();
        //             covered++;
        //             left--;

        //             for(int neigh:graph.get(node)){
        //                 if(!visited[neigh]){
        //                     q.add(neigh);
        //                     visited[neigh]=true;
        //                 }

        //             }
        //         }
        //         ans+=(long)(covered*left);
        //     }
        // }

        // return ans; 




        
        DSU obj=new DSU(n);

        for(int[] edge:edges){
            obj.unionBySize(edge[0],edge[1]);
        }

        long ans=0;
        long left=n;
        for(int i=0;i<n;i++){
            if(obj.findParent(i) == i){
                long reachable=obj.size[i];
                long nonreachable=left-reachable;

                ans+=(long)(reachable*nonreachable);

                left-=reachable;
            }
        }

        return ans;

        

        


        
    }
}