class Solution {
    // public boolean wordPattern(String pattern, String s) {
    //     String word[]=s.split(" ");
    //     if(word.length!=pattern.length()) return false;
    //     HashMap<Character,String> h=new HashMap<>();
    //     for(int i=0;i<word.length;i++){
    //         char ch=pattern.charAt(i);
    //         String w=word[i];

    //         if(h.containsKey(ch)){
    //             if(!h.get(ch).equals(w)) return false;
    //         }else if(h.containsValue(w)){
    //             return false;
    //         }else{
    //             h.put(ch,w);
    //         }  
    //     }
    //     return true;
    // }
    public boolean wordPattern(String pattern, String s) {
        String word[]=s.split(" ");
        if(word.length!=pattern.length()) return false;
        HashMap<Character,String> h=new HashMap<>();
        HashMap<String,Character> h2=new HashMap<>();
        for(int i=0;i<word.length;i++){
            char ch=pattern.charAt(i);
            String w=word[i];

            if(h.containsKey(ch)){
                if(!h.get(ch).equals(w)) return false;
            }else if(h2.containsKey(w)){
                if(!h2.get(w).equals(ch)) return false;
            }else{
                h.put(ch,w);
                h2.put(w,ch);
            }  
        }
        return true;
    }

}