class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> h=new HashMap<>();
        for(char ch:s1.toCharArray()){
            h.put(ch,h.getOrDefault(ch,0)+1);
        }

        int i=0,j=0,k=s1.length();
        int count=h.size();

        while(j<s2.length()){
            if(h.containsKey(s2.charAt(j))){
                h.put(s2.charAt(j),h.get(s2.charAt(j))-1);
                if(h.get(s2.charAt(j))==0){
                    count--;
                }
            }
            if(j-i+1<k) j++;
            else if(j-i+1==k){
                if(count==0){
                    return true;
                }

                if(h.containsKey(s2.charAt(i))){
                    if(h.get(s2.charAt(i))==0) count++;
                    h.put(s2.charAt(i),h.get(s2.charAt(i))+1);
                }
                i++;
                j++;
            }
        }
        return false;
    }
}