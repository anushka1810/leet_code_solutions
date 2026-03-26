class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        HashMap<Character,Integer> h=new HashMap<>();

        for(char ch:t.toCharArray()){
            h.put(ch,h.getOrDefault(ch,0)+1);
        }
        int count=h.size();
        int ans=Integer.MAX_VALUE;
        int x=-1,y=-1;

        int i=0,j=0;
        while(j<s.length()){
            if(h.containsKey(s.charAt(j))){
                h.put(s.charAt(j),h.get(s.charAt(j))-1);
                if(h.get(s.charAt(j))==0){
                    count--;
                }
            }

        //     while(i<=j){
        //         if(h.containsKey(s.charAt(i))){
        //             if(h.get(s.charAt(i))<0){
        //                 h.put(s.charAt(i),h.get(s.charAt(i))+1);
        //             }else{
        //                 break;
        //             }
        //         }
        //         i++;
        //     }
        //     if(count==0){
        //         if(j-i+1<ans){
        //             ans=j-i+1;
        //             x=i;
        //             y=j;
        //         }
        //     }
        //     j++;
        // }

            while(i<=j && count==0){
                if(j-i+1<ans){
                    ans=j-i+1;
                    x=i;
                }
                if(h.containsKey(s.charAt(i))){
                    h.put(s.charAt(i),h.get(s.charAt(i))+1);
                    if(h.get(s.charAt(i))>0) count++;  
                }
                i++;
            }
                      
                
            j++;
        }

        if(ans==Integer.MAX_VALUE) return "";
        return s.substring(x,x+ans);
    }
}