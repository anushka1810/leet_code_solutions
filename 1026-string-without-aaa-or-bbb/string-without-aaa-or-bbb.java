class Solution {
    public String helperA(int a,int b){
        StringBuilder ans=new StringBuilder();
        int Aparts=(a+2)/2;
        int Bparts=b/Aparts;
        int rem=b%Aparts;

        while(a>0 || b>0){
            for(int i=0;i<Math.min(a,2);i++){
                ans.append("a");
                a--;
            }
            int bval=Bparts;
            if(rem>0){
                bval+=1;
                rem--;
            }
            for(int i=0;i<Math.min(bval,2);i++){
                ans.append("b");
                b--;
                //rem--;
            }
        }

        return ans.toString();
    }
    public String helperB(int a,int b){
        StringBuilder ans=new StringBuilder();
        int Bparts=(b+2)/2;
        int Aparts=a/Bparts;
        int rem=a%Bparts;



        while(a>0 || b>0){
            for(int i=0;i<Math.min(b,2);i++){
                ans.append("b");
                b--;
            }
            int aval=Aparts;
            if(rem>0){
                aval+=1;
                rem--;
            }
            for(int i=0;i<Math.min(aval,2);i++){
                ans.append("a");
                a--;
            }
        }

        return ans.toString();
    }
    public String strWithout3a3b(int a, int b) {
        // int idx=0;

        // StringBuilder s=new StringBuilder();
        // while(a>0 || b>0){
        //     StringBuilder temp=new StringBuilder();
        //     int timeA=Math.min(2,a);
        //     for(int i=0;i<timeA;i++){
        //         temp.append("a");
        //         a--;
        //     }
        //     int timeB=Math.min(2,b);
        //     for(int i=0;i<timeB;i++){
        //         temp.append("b");
        //         b--;
        //     }

        //     s.append(temp);
        // }
        // return s.toString(); 
        if(a>b) return helperA(a,b);
        return helperB(a,b);      
    }
}