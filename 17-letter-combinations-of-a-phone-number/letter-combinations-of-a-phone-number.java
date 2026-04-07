class Solution {
    Map<Integer,char[]> h=new HashMap<>();
    // h.put(1,"");
    public Solution(){
        h.put(2,new char[]{'a','b','c'});
        h.put(3,new char[]{'d','e','f'});
        h.put(4,new char[]{'g','h','i'});
        h.put(5,new char[]{'j','k','l'});
        h.put(6,new char[]{'m','n','o'});
        h.put(7,new char[]{'p','q','r','s'});
        h.put(8,new char[]{'t','u','v'});
        h.put(9,new char[]{'w','x','y','z'});

    }

    public void solve(int idx,String digits,StringBuilder temp,List<String> ans){
        if(idx==digits.length()){
            ans.add(temp.toString());
            return;
        }
        char arr[]=h.get(digits.charAt(idx)-'0');
        for(int i=0;i<arr.length;i++){
            temp.append(arr[i]);
            int size=temp.length();

            solve(idx+1,digits,temp,ans);

            temp.deleteCharAt(size-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        solve(0,digits,temp,ans);
        return ans;
    }
}