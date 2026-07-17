class Solution {
    class Pair{
        int v;
        int color;

        Pair(int v,int color){
            this.v=v;
            this.color=color;
        }
    }
    public boolean isBipartite2(int[][] graph,int i,int[] color) {
        
        Queue<Pair> q=new LinkedList<>();


        q.add(new Pair(i,0));
        color[0]=0;

        while(!q.isEmpty()){
            Pair node=q.poll();

            for(int neigh:graph[node.v]){
                if(color[neigh]==-1){
                    color[neigh]=1-node.color;
                    q.add(new Pair(neigh,color[neigh]));
                }else if(color[neigh]==node.color){
                    return false;
                }
            }
        }

        return true;


    }

    public boolean isBipartite(int[][] graph){
        int V=graph.length;
        int color[]=new int[V];
        Arrays.fill(color,-1);

        for(int i=0;i<V;i++){
            if(color[i]==-1 && !isBipartite2(graph,i,color)) return false;
        }

        return true;


    }
}