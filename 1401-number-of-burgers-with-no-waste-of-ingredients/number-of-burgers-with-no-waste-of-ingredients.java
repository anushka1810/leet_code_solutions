class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans=new ArrayList<>();


        int canMakeSmallBurger=cheeseSlices*2;
        int rem=tomatoSlices-canMakeSmallBurger;

        if(rem<0 || rem%2!=0) return ans;
        int canMakeBigBurger=rem/2;

        if(canMakeBigBurger>cheeseSlices) return ans;

        ans.add(canMakeBigBurger);
        ans.add(cheeseSlices-canMakeBigBurger);
        return ans;
    }
}