class Trie {
    class Node{
        Node[] children;
        boolean eow;

        Node(){
            children=new Node[26];
            // for(int i=0;i<26;i++){
            //     children[i]=null;
            // }
            eow=false;
        }
    }
    Node root;
    public Trie() {

        this.root=new Node();

    }
    
    public void insert(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';

            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];

            if(i==word.length()-1){
                curr.eow=true;
            }
        }
    }
    
    public boolean search(String word) {
        Node curr=root;

        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';

            if(curr.children[idx]==null) return false;
            // if(i=word.length()-1 && !curr.children[idx].eow) return false;
            curr=curr.children[idx];
            if(i==word.length()-1 && !curr.eow) return false;
            
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        Node curr=root;

        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';

            if(curr.children[idx]==null) return false;
            curr=curr.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */