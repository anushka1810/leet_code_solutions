class Solution {
    class Trie{
        int idx;
        Trie children[];

        Trie(){
            this.children=new Trie[26];
            for(int i=0;i<26;i++){

                children[i]=null;
            }
            this.idx=-1;
        }
    }
    Trie root=new Trie();
    public void build(String[] wordsContainer){
        int minLength=0;
        for(int j=0;j<wordsContainer.length;j++){
            int n=wordsContainer[j].length();
            Trie temp=root;
            for(int i=n-1;i>=0;i--){
                char ch=wordsContainer[j].charAt(i);
                int idx1=ch-'a';

                if(temp.children[idx1]==null){
                    temp.children[idx1]=new Trie();
                    temp.children[idx1].idx=j;
                }else{
                    int prev=temp.children[idx1].idx;
                    if(wordsContainer[j].length()<wordsContainer[prev].length()){
                        temp.children[idx1].idx=j;
                    }

                }
                temp=temp.children[idx1];
            }

            if(wordsContainer[minLength].length()>wordsContainer[j].length()) minLength=j;
        }

        root.idx=minLength;
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        build(wordsContainer);
        int ans[]=new int[wordsQuery.length];


        for(int j=0;j<wordsQuery.length;j++){
            Trie temp=root;
            int n=wordsQuery[j].length();

            for(int i=n-1;i>=0;i--){
                int index=wordsQuery[j].charAt(i)-'a';

                if(temp.children[index]==null){
                    break;
                }

                temp=temp.children[index];
            }
            ans[j]=temp.idx;
        }
        return ans;
        
    }
}