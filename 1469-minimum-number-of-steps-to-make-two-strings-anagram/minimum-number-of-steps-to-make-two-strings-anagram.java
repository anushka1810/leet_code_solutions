class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> freq=new HashMap<>();
        for(int i=0;i<s.length();i++){
            freq.put(s.charAt(i),freq.getOrDefault(s.charAt(i),0)+1);
            freq.put(t.charAt(i),freq.getOrDefault(t.charAt(i),0)-1);
        }
        int ans=0;
        for(char ch:freq.keySet()){
            if(freq.get(ch)>0){
                ans+=freq.get(ch);

            }
        }
        return ans;



        
    }
}