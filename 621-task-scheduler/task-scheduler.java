class Solution {
    class Pair{
        char ch;
        int freq;
        int canStartAt;

        Pair(char ch,int freq){
            this.ch=ch;
            this.freq=freq;
        }
    }
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character,Integer> h=new HashMap<>();

        for(char ch:tasks){
            h.put(ch,h.getOrDefault(ch,0)+1);
        }
        int count=h.size();

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(b.freq-a.freq));
        for(char ch:h.keySet()){
            pq.add(new Pair(ch,h.get(ch)));
        }



        int ans=0;
        Queue<Pair> bacche_hue_task=new LinkedList<>();


        while(pq.size()>0){
            // Pair Node =pq.poll();

            // if(Node.canStartAt>time){
            //     time=Node.canStartAt;
            // }
            // if(Node.freq>1){
            //     pq.add(new Pair(Node.ch,Node.freq-1,Node.canStartAt+n+1));
            // }
            // time++;


            for(int i=0;i<=n;i++){
                if(pq.isEmpty() && bacche_hue_task.size()==0){
                    ans+=i;
                    break;
                }else if(pq.isEmpty() && bacche_hue_task.size()>0){
                    ans+=n+1;
                    break;
                }
                if(i==n) ans+=n+1;
                Pair node=pq.poll();
                if(node.freq>1){
                    bacche_hue_task.add(new Pair(node.ch,node.freq-1));
                }
            }

            while(bacche_hue_task.size()>0){
                pq.add(bacche_hue_task.poll());
            }
        }


        return ans;

        
    }
}