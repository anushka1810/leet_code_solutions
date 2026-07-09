class Solution {
    public void build(int[] basket,int[] segment,int l,int r,int idx){
        if(l==r){
            segment[idx]=basket[l];
            return;
        }

        int mid=l+(r-l)/2;

        build(basket,segment,l,mid,(2*idx)+1);
        build(basket,segment,mid+1,r,(2*idx)+2);

        segment[idx]=Math.max(segment[(2*idx)+1],segment[(2*idx)+2]);
    }

    public boolean canPlace(int[] segment,boolean[] assigned,int target,int currL,int currR,int idx){

        if(segment[idx] < target) return false;
        if(currL==currR){
            if(segment[idx]>=target && !assigned[currL]){
                segment[idx]=Integer.MIN_VALUE;
                return true;
            }
            return false;
        }
        

        int mid=currL+(currR-currL)/2;
        if(canPlace(segment,assigned,target,currL,mid,(2*idx)+1)){
            segment[idx]=Math.max(segment[(2*idx)+1],segment[(2*idx)+2]);
            return true;
        }
        if(canPlace(segment,assigned,target,mid+1,currR,(2*idx)+2)){
            segment[idx]=Math.max(segment[(2*idx)+1],segment[(2*idx)+2]);
            return true;
        }

        return false;

    }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=fruits.length;
        int segment[]=new int[4*n];

        build(baskets,segment,0,n-1,0);
        int ans=0;
        boolean[] assigned=new boolean[n];

        for(int num:fruits){
            if(!canPlace(segment,assigned,num,0,n-1,0)) ans++;
        }

        return ans;
    }
}