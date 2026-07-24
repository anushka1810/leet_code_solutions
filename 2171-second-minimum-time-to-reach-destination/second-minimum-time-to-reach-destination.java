class Solution {
    class Pair{
        int node;
        int dist;
        // boolean signal;
        Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
            // this.signal=signal;
        }
    }
    public int secondMinimum(int n, int[][] edges, int time, int change) {

        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int [] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }


        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->(a.dist-b.dist));

        int[] first=new int[n+1];
        int[] second=new int[n+1];

        Arrays.fill(first,Integer.MAX_VALUE);
        Arrays.fill(second,Integer.MAX_VALUE);

        
        q.add(new Pair(1,0));
        first[1]=0;


        while(!q.isEmpty()){
            Pair details=q.poll();
            int d=details.dist;
            int wait=0;

            if(d>second[details.node]) continue;


            int ch=d/change;
            if(ch%2==1) wait=change-d%change;
            int newTime=d+wait+time;
            for(int neigh:graph.get(details.node)){
                if(newTime<first[neigh]){
                    second[neigh]=first[neigh];
                    first[neigh]=newTime;

                    q.add(new Pair(neigh,newTime));
                }else if(newTime>first[neigh] && newTime<second[neigh]){
                    second[neigh]=newTime;
                    q.add(new Pair(neigh,newTime));
                }
            }
        }


        return second[n];





        
    }
}