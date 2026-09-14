class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n=customers.length;
        int initial=0;

        for(int i=0;i<n;i++){
            if(grumpy[i]==0){
                initial+=customers[i];
            }
        }
        int i=0,j=0;
        int max=initial;
        int newSatisfiedCustomer=0;
        int k=minutes;
        while(j<n){
            if(grumpy[j]==1){
                newSatisfiedCustomer+=customers[j];
            }

            if(j-i+1<k) j++;
            else if(j-i+1==k){
                int nsum=initial+newSatisfiedCustomer;
                if(nsum>max){
                    max=nsum;
                }

                if(grumpy[i]==1){
                    newSatisfiedCustomer-=customers[i];
                }

                i++;
                j++;

            }
        }
        return max;
    }
}