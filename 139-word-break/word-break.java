class Solution {
    Node root=new Node();
    HashMap<String, Boolean> memo = new HashMap<>();

    class Node{
        Node child[];
        boolean eow;

        Node(){
            child=new Node[26];
            for(int i=0;i<26;i++){
                child[i]=null;
            }
            eow=false;
        }
    }

    public void build(String s){
        Node curr=root;
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';

            if(curr.child[idx]==null){
                curr.child[idx]=new Node();
            }
            curr=curr.child[idx];
            if(i==s.length()-1) curr.eow=true;
        }
    }

    public boolean search(String s){

        Node curr=root;

        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';

            if(curr.child[idx]==null){
                return false;
            }
            curr=curr.child[idx];
            if(i==s.length()-1 && curr.eow==true) return true;
        }
        return false;
    }

    public boolean divide(String s){
        if(s.equals("")) return true;

        if (memo.containsKey(s)) return memo.get(s);
        for(int i=1;i<=s.length();i++){
            String first=s.substring(0,i);
            String second=s.substring(i);

            if(search(first) && divide(second)){
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);

        return false;

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        // trie implmentation 

        for(String word:wordDict){
            build(word);
        }

        return divide(s);

        
    }
}