class WordDictionary {
    class Node{
        Node children[]=new Node[26];
        boolean eow=false;
    }
    Node root;

    public WordDictionary() {
        this.root=new Node();
    }
    
    public void addWord(String word) {
        Node curr=root;

        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';

            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }

        curr.eow=true;
    }
    public boolean dfs(String word,int idx,Node curr){
        if(curr==null) return false;

        if(idx==word.length()) return curr.eow;

        if(word.charAt(idx)=='.'){
            for(int i=0;i<26;i++){
                if(curr.children[i]!=null){
                    if(dfs(word,idx+1,curr.children[i])) return true;
                }
            }
        }else{
            int i=word.charAt(idx)-'a';
            return dfs(word,idx+1,curr.children[i]);
        }

        return false;



    }
    
    public boolean search(String word) {
        return dfs(word,0,root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */