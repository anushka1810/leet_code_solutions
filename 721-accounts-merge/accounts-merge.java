class Solution { 
    class Dsu{
        int[] Parent;
        int[] rank;
        int[] size;
        Dsu(int V){
            this.Parent=new int[V];
            this.rank=new int[V];
            this.size=new int[V];
            for(int i=0;i<V;i++){
                Parent[i]=i;
                rank[i]=0;
                size[i]=1;
            }
        }
        public int FindParent(int x){
            if(Parent[x]!=x){
                Parent[x]=FindParent(Parent[x]);
            }
            return Parent[x];
        }
        public void UnionByRank(int a,int b){
            int p1=FindParent(a);
            int p2=FindParent(b);

            if(p1==p2) return;

            int r1=rank[p1];
            int r2=rank[p2];

            if(r1==r2){
                Parent[p2]=p1;
                rank[p1]+=1;
            }else if(r1>r2){
                Parent[p2]=p1;
            }else{
                Parent[p1]=p2;
            }
        }
        public void UnionBySize(int a,int b){
            int p1=FindParent(a);
            int p2=FindParent(b);

            if(p1==p2) return ;

            int s1=size[p1];
            int s2=size[p2];

            if(s1>=s2){
                Parent[p2]=p1;
                size[p1]+=size[p2];
            }else{
                Parent[p1]=p2;
                size[p2]+=size[p1];
            }
        }

    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int V=accounts.size();
        Dsu ds=new Dsu(V);
        HashMap<String,Integer> emailtoOwnerInNumber=new HashMap<>();
        for(int i=0;i<V;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email=accounts.get(i).get(j);
                if(emailtoOwnerInNumber.containsKey(email)){
                    ds.UnionByRank(i,emailtoOwnerInNumber.get(email));
                }else{
                    emailtoOwnerInNumber.put(email,i);
                }
            }
        }

        HashMap<Integer,List<String>> OwnerNumberToMail=new HashMap<>();
        for(String email:emailtoOwnerInNumber.keySet()){
            int parent=ds.FindParent(emailtoOwnerInNumber.get(email));
            if(OwnerNumberToMail.containsKey(parent)){
                OwnerNumberToMail.get(parent).add(email);
            }else{
                List<String> a=new ArrayList<>();
                a.add(email);
                OwnerNumberToMail.put(parent,a);
            }
        }



        List<List<String>> ans=new ArrayList<>();
        

        for(int idx:OwnerNumberToMail.keySet()){
            Collections.sort(OwnerNumberToMail.get(idx));
            OwnerNumberToMail.get(idx).add(0,accounts.get(idx).get(0));
            ans.add(OwnerNumberToMail.get(idx));
        }

        return ans;


    }
}