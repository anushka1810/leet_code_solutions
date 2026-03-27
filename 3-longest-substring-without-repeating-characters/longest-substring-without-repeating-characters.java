class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> h=new HashMap<>();
        int i=0,j=0,ans=0;

        while(j<s.length()){
            char c1=s.charAt(j);
            h.put(c1,h.getOrDefault(c1,0)+1);

            while(i<=j && j-i+1>h.size()){
                char c2=s.charAt(i);
                h.put(c2,h.get(c2)-1);
                if(h.get(c2)==0){
                    h.remove(c2);
                }
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}