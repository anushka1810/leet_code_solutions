class Solution {


    class DSU{
        int V;
        int parent[];
        int rank[];
        int size[];

        DSU(int V){
            this.V=V;
            this.parent=new int[V];
            this.rank=new int[V];
            this.size=new int[V];

            for(int i=0;i<V;i++){
                parent[i]=i;
                rank[i]=0;
                size[i]=1;
            }
        }

        public int FindParent(int x){
            if(parent[x]!=x){
                parent[x]=FindParent(parent[x]);
            }

            return parent[x];

        }
        public void UnionBySize(int x,int y){
            int ParentX=FindParent(x);
            int ParentY=FindParent(y);

            if(ParentX==ParentY) return;

            if(size[ParentX]>=size[ParentY]){
                parent[ParentY]=ParentX;
                size[ParentX]+=size[ParentY];
            }else{
                parent[ParentX]=ParentY;
                size[ParentY]+=size[ParentX];
            }
        }
        public void UnionByRank(int x,int y){
            int ParentX=FindParent(x);
            int ParentY=FindParent(y);

            if(ParentX==ParentY) return;

            if(rank[ParentX]==rank[ParentY]){
                parent[ParentY]=ParentX;
                rank[ParentX]+=1;
            }else if(rank[ParentX]>rank[ParentY]){
                parent[ParentY]=ParentX;
            }else{
                parent[ParentX]=ParentY;
            }
        }
    }
    public boolean equationsPossible(String[] equations) {

        DSU obj1=new DSU(26);
        for(String s:equations){
            char node1=s.charAt(0);
            char node2=s.charAt(3);
            if(s.charAt(1)=='='){
                int x=node1-'a';
                int y=node2-'a';
                obj1.UnionByRank(x,y);

            }
        }
        for(String s:equations){
            char node1=s.charAt(0);
            char node2=s.charAt(3);
            if(s.charAt(1)=='!'){
                int x=node1-'a';
                int y=node2-'a';
                
                if(obj1.FindParent(x)==obj1.FindParent(y)) return false;

            }
        }

        return true;
        
    }
}