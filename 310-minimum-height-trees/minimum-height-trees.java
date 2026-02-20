class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // maine kaha mai har ek node ke liye bfs call kr lu 
        // agr uss node ko root maan ke bfs call se level jo aye that is less than min count=1,greater than toh ignore and eqaul to min than count++;
        // but n*(n*(n-1)) ~o(n^3) very much

        List<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        int indegree[]=new int[n];
        if(n==1){
            ans.add(0);
            return ans;
        }

        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }


        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }

        for(int i=0;i<n;i++){
            if(indegree[i]==1){
                q.add(i);
            }
        }
        int remaining=n;

        while(remaining>2){
            int size=q.size();

            for(int i=0;i<size;i++){
                int node=q.poll();
                for(int neigh:graph.get(node)){
                    indegree[neigh]--;
                    if(indegree[neigh]==1) q.add(neigh);
                }
            }
            remaining-=size;
        }

        for(int num:q){
            ans.add(num);
        }
        return ans;



        
    }
}