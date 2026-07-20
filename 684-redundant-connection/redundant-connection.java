class Solution {

    class DSU{
        int v;
        int parent[];
        int size[];
        int rank[];

        DSU(int v){
            this.v=v;
            this.parent=new int[v+1];
            this.size=new int[v+1];
            this.rank=new int[v+1];

            for(int i=1;i<=v;i++){
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
    public int[] findRedundantConnection(int[][] edges) {

        DSU obj=new DSU(edges.length);

        for(int edge[]:edges){

            int parentX=obj.findParent(edge[0]);
            int parentY=obj.findParent(edge[1]);

            if(parentX==parentY) return edge;
            else obj.unionByrank(edge[0],edge[1]);
        }
        return new int[]{};
    }
}