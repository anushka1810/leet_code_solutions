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
    public String reorganizeString(String s) {
        HashMap<Character,Integer> h=new HashMap<>();
        char [] tasks=s.toCharArray();

        for(char ch:tasks){
            h.put(ch,h.getOrDefault(ch,0)+1);
        }
        // int count=h.size();

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(b.freq-a.freq));
        for(char ch:h.keySet()){
            pq.add(new Pair(ch,h.get(ch)));
        }



        int ans=0;
        Queue<Pair> bacche_hue_task=new LinkedList<>();
        StringBuilder sans=new StringBuilder();


        while(pq.size()>0){
            for(int i=0;i<2;i++){
                if(pq.isEmpty() && bacche_hue_task.size()==0){
                    return sans.toString();
                }else if(pq.isEmpty() && bacche_hue_task.size()>0){
                    return "";
                }
                if(sans.length()==s.length()) return sans.toString();
                Pair node=pq.poll();
                sans.append(node.ch);
                if(node.freq>1){
                    bacche_hue_task.add(new Pair(node.ch,node.freq-1));
                }
            }

            while(bacche_hue_task.size()>0){
                pq.add(bacche_hue_task.poll());
            }
        }


        return sans.toString();
    }
}