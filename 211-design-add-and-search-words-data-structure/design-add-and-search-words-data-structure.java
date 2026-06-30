class WordDictionary {
    class trie{
        trie[] children;
        boolean eow;
        trie(){
            this.children=new trie[26];
            this.eow=false;
            for(int i=0;i<26;i++){
                children[i]=null;
            }

        }
    }

    trie root;
    public WordDictionary() {
        this.root=new trie(); 
    }
    
    public void addWord(String word) {
        trie curr=root;

        for(char ch:word.toCharArray()){
            int idx=ch-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new trie();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    

    public boolean dfs(String word,int i,trie curr){
        if(i==word.length()) return curr.eow;

        if(word.charAt(i)=='.'){
            for(int j=0;j<26;j++){
                if(curr.children[j]!=null){
                    if(dfs(word,i+1,curr.children[j])) return true;
                }
            }
        }else{
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null) return false;
            if(dfs(word,i+1,curr.children[idx])) return true;
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