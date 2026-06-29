class Solution {
    class Pair{
        int h;
        int pos;
        int originalIndex;
        char dir;
        Pair(int h,int pos,int originalIndex,char dir){
            this.h=h;
            this.pos=pos;
            this.originalIndex=originalIndex;
            this.dir=dir;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n=positions.length;
        List<Pair> robo=new ArrayList<>();
        for(int i=0;i<n;i++){
            robo.add(new Pair(healths[i],positions[i],i,directions.charAt(i)));
        }

        robo.sort((a,b)->Integer.compare(a.pos,b.pos));


        Stack<Pair> st=new Stack<>();

        for(Pair curr:robo){
            if(curr.dir=='R'){
                st.push(curr);
            }else{

                while(!st.isEmpty() && curr.h>0){
                    Pair prev=st.peek();

                    if(prev.h>curr.h){
                        prev.h--;
                        curr.h=0;
                    }else if(prev.h<curr.h){
                        prev.h=0;
                        curr.h--;
                        st.pop();
                    }else{
                        prev.h=0;
                        curr.h=0;
                        st.pop();
                    }
                }    
            }
        }

        robo.sort((a,b)->Integer.compare(a.originalIndex,b.originalIndex));

        List<Integer> ans=new ArrayList<>();

        for(Pair r:robo){
            if(r.h>0){
                ans.add(r.h);
            }
        }
        return ans;


        
    }
}