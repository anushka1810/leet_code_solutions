class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder a=new StringBuilder();
        int x=0;
        int rep=s.length()/(2*k);
        System.out.println(rep);
        for(int i=0;i<rep;i++){
            StringBuilder y=new StringBuilder();
            for(int j=0;j<2*k;j++){
                if(j<k){
                    y.append(s.charAt(x));
                    x++; 
                }else{
                    if(j==k){
                        y=y.reverse();
                    }
                    y.append(s.charAt(x));
                    x++;
                }
            }
            a.append(y.toString());
        }
        StringBuilder res=new StringBuilder();
        if((s.length()%(2*k)<k)){
            for(int f=x;f<s.length();f++){
                res.append(s.charAt(f));
            }
            res=res.reverse();
            a.append(res);
        }
        else{
            for(int f=x;f<x+k;f++){
                res.append(s.charAt(f));
            }
            res=res.reverse();
            for(int l=x+k;l<s.length();l++){
                res.append(s.charAt(l));
            }
            a.append(res);
        }
        return a.toString();
    }
}