class Solution {
    public boolean dfs(int currNode,int [][] edges,boolean[] visited,boolean[] path){
        visited[currNode]=true;
        path[currNode]=true;
        
        for(int[] edge:edges){
            if(edge[0]==currNode){
                if(!visited[edge[1]]){
                    if(dfs(edge[1],edges,visited,path)) return true;
                }else if(path[edge[1]]){
                    return true;
                }
            }
        }
        
        path[currNode]=false;
        return false;
    }
    public boolean canFinish(int V, int[][] edges) {
        boolean visited[]=new boolean[V];
        boolean path[]=new boolean[V];
        
        
        for(int i=0;i<V;i++){
            if(!visited[i] && dfs(i,edges,visited,path)){
                return false;
            }
        }

        
        return true;
    }
}