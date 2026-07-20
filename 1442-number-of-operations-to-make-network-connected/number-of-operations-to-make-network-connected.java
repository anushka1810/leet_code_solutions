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
    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n-1) return -1;

        DSU obj=new DSU(n);

        int couldremove=0;
        for(int[] edge:connections){
            int parentX=obj.findParent(edge[0]);
            int parentY=obj.findParent(edge[1]);

            if(parentX==parentY) couldremove++;
            obj.unionByrank(edge[0],edge[1]);
        }

        int component=0;
        for(int i=0;i<n;i++){
            if(obj.findParent(i)==i) component++;
        }

        if(component>couldremove+1) return -1;

        return component-1;
        
    }
}