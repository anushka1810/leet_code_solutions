class Solution {
    public char findTheDifference(String s, String t) {
        char a[]=s.toCharArray();
        char b[]=t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        int n=Arrays.mismatch(a,b);
        return b[n];
        // for(int i=0;i<b.length;i++){
        //     char c=b[i];
        //     int count=0;
        //     for(int j=0;j<a.length;j++){
        //         if(a[j]==c){
        //             count++;
        //             break;
        //         }
        //     }
        //     if (count==0){
        //         return c;
        //     }
        // } 
        // return 'a';   
    }
}