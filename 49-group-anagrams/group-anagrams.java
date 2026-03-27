class Solution {
    public static String sort(String s){
        char arr[]=s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);        
    }
    public List<List<String>> groupAnagrams(String[] stringarr) {
        HashMap<String,List<String>> h=new HashMap<>();
        for(int i=0;i<stringarr.length;i++){
            String same=sort(stringarr[i]);
            if(!h.containsKey(same)){
                h.put(same,new ArrayList<>());
            }
            h.get(same).add(stringarr[i]);
        }
        return new ArrayList<>(h.values());
    }
}