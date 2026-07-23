class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int v=colors.length();
        int indegree[]=new int[v];

        for(int[] edge:edges){
            indegree[edge[1]]++;
        }
        int count=0;
        int dp[][]=new int[v][26];
        boolean visited[]=new boolean[v];
        int max=Integer.MIN_VALUE;
        List<List<Integer>> graph=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
            if(indegree[i]==0){
                q.add(i);
            }
        }

        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
        }


        if(q.isEmpty()) return -1;

        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            int idx=colors.charAt(node)-'a';
            dp[node][idx]++;
            if(dp[node][idx]>max) max=dp[node][idx];
            for(int neigh:graph.get(node)){
                for(int c=0;c<26;c++){
                    dp[neigh][c] =Math.max(dp[neigh][c],dp[node][c]);
                }
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }

        if(count!=v) return -1;

        return max;
    }
}