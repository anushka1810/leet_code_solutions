class Solution {
    public void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public int firstMissingPositive(int[] nums) {
        // isme hum ek array chahiye which store which whether it is present or not 
        // but hum space nhi use kr sakte why not use same array 
        // toh hum iss hi array ko use kr le 
        // dekho ans max 1 se n(both include) tak hi ho sakta h agr 1 se n-1 tak sb present hai toh n else n se kam hi 
        // toh hum array ke index 0-n-1 me +1 krke kam bann jayega 
        //


        int n=nums.length;
        int i=0;
        while(i<n){
            if(nums[i]<n+1 && nums[i]>=1){
                if(i==nums[i]-1 || nums[nums[i]-1]==nums[i]) i++;
                else{
                    swap(nums,i,nums[i]-1);
                }
            }else{
                i++;
            }
        }

        for(int j=0;j<n;j++){
            if(nums[j]!=j+1) return j+1;
        }

        return n+1;
    }
}