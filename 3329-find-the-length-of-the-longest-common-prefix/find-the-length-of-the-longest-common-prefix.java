class Solution {
    class Trie{
        Trie children[];

        Trie(){
            this.children=new Trie[10];

            for(int i=0;i<10;i++){
                children[i]=null;
            }
        }
    }

    Trie root=new Trie();
    public void build(int[] arr){
        for(int num:arr){
            Trie temp=root;
            String str=String.valueOf(num);
            for(int i=0;i<str.length();i++){
                int val=str.charAt(i)-'0';
                if(temp.children[val]==null){
                    temp.children[val]=new Trie();
                }
                temp=temp.children[val];
            }
        }
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        
        build(arr1);
        int ans=Integer.MIN_VALUE;

        for(int num:arr2){
            Trie temp=root;
            String str=String.valueOf(num);
            int count=0;
            for(int i=0;i<str.length();i++){
                int val=str.charAt(i)-'0';
                if(temp.children[val]==null){
                    break;
                }
                count++;
                temp=temp.children[val];
            }

            ans=Math.max(count,ans);

        }

        return ans;
    }
}