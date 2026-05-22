class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> h=new HashMap<>();

        int i=0,j=0;
        while(j<s.length()){
            if(j-i+1<10) j++;
            else if(j-i+1==10){
                String str1=s.substring(i,j+1);
                h.put(str1,h.getOrDefault(str1,0)+1);

                i++;
                j++;
            }
        }
        List<String> ans=new ArrayList<>();
        for(String s1:h.keySet()){
            if(h.get(s1)>1) ans.add(s1);
        }
        return ans;
    }
}