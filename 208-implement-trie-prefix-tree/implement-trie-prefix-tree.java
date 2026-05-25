    class Node{
        Node children[];
        boolean eow;

        Node(){
            this.children=new Node[26];
            for(int i=0;i<26;i++){
                this.children[i]=null;
            }
            this.eow=false;
        }
    }
class Trie {
    Node root;

    public Trie() {
        this.root=new Node();
        
    }
    
    public void insert(String word) {
        Node temp=root;

        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';

            if(temp.children[index]==null){
                temp.children[index]=new Node();
            }
            temp=temp.children[index];
        }
        temp.eow=true;
    }
    
    public boolean search(String word) {
        Node temp=root;

        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';

            if(temp.children[index]==null){
                return false;
            }
            temp=temp.children[index];
        }
        return temp.eow;
        
    }
    
    public boolean startsWith(String word) {
        Node temp=root;

        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';

            if(temp.children[index]==null){
                return false;
            }
            temp=temp.children[index];
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