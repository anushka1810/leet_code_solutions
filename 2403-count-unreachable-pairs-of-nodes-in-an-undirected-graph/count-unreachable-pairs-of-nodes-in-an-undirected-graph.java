class Solution {
    public long countPairs(int n, int[][] edges) {

        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q=new LinkedList<>();
        boolean visited[]=new boolean[n];
        long left=n;
        long ans=0;


        for(int i=0;i<n;i++){
            if(!visited[i]){
                q.add(i);
                visited[i]=true;
                long covered=0;
                while(!q.isEmpty()){
                    int node=q.poll();
                    covered++;
                    left--;

                    for(int neigh:graph.get(node)){
                        if(!visited[neigh]){
                            q.add(neigh);
                            visited[neigh]=true;
                        }

                    }
                }
                ans+=(long)(covered*left);
            }
        }

        return ans; 
        
    }
}