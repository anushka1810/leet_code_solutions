class Node{
    Node children[];
    boolean eow;
    int idx;

    Node (){
        this.children=new Node[26];
        for(int i=0;i<26;i++){
            this.children[idx]=null;
        }
        this.eow=false;
        this.idx=-1;
    }
}

class Trie{

    Node root;
    Trie(){
        this.root=new Node();
    }

    public void insert(String s,int index,String[] wordContainer){
        Node temp=root;
        for(int i=0;i<s.length();i++){
            int idx1=s.charAt(i)-'a';

            if(temp.children[idx1]==null){
                temp.children[idx1]=new Node();
            }
            temp=temp.children[idx1];
            if(temp.idx==-1 || wordContainer[temp.idx].length()>wordContainer[index].length()) temp.idx=index;
        }
        temp.eow=true;
    }

    public int prefixFind(String s){
        Node temp=root;

        for(int i=0;i<s.length();i++){
            int idx1=s.charAt(i)-'a';

            if(temp.children[idx1]==null) return temp.idx;
            temp=temp.children[idx1];
        }
        return temp.idx;
    }
}

class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        Trie t=new Trie();
        int min=0;
        for(int i=0;i<wordsContainer.length;i++){
            if(wordsContainer[i].length()<wordsContainer[min].length()) min=i;
            StringBuilder s=new StringBuilder(wordsContainer[i]);
            s.reverse();
            t.insert(s.toString(),i,wordsContainer);
        }
        int ans[]=new int[wordsQuery.length];
        for(int i=0;i<wordsQuery.length;i++){
            StringBuilder s=new StringBuilder(wordsQuery[i]);
            s.reverse();
            ans[i]=t.prefixFind(s.toString());
            if(ans[i]==-1){
                ans[i]=min;
            }
        }

        return ans;        
    }
}