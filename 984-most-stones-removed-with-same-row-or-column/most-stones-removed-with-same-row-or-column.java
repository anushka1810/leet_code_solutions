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
    public int removeStones(int[][] stones) {
        int n=stones.length;
        DSU obj=new DSU(n);
        int comp=0;


        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    int x=obj.findParent(i);
                    int y=obj.findParent(j);

                    if(x!=y) obj.unionByrank(i,j);
                }
            }
        }


        for(int i=0;i<n;i++){
            if(obj.findParent(i)==i){
                comp++;
            }
        }

        return n-comp;
    }
}