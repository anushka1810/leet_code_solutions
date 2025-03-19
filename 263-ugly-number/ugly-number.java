class Solution {
    public boolean isUgly(int n) {
    //     for(int i=2;i<n;i++){
    //         if(n%i==0 ){
    //             if(i==2||i==3||i==5){
    //                 continue;
    //             }else{
    //                 // System.out.println(i);
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
        int c=n;
        if(n==0){
            return false;
        }
        while(c!=1){
            if(c%2==0){
                c=c/2;
            }else if(c%3==0){
                c=c/3;
            }else if(c%5==0){
                c=c/5;
            }
            else{
                return false;
            }
        }
        return true;
    }
}