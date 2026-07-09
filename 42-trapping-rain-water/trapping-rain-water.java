class Solution {
    public int trap(int[] height) {
        // int n = height.length;
        // int left = 0, right = n - 1;
        // int leftMax = 0, rightMax = 0;
        // int water = 0;

        // while (left < right) {
        //     if (height[left] < height[right]) {
        //         if (height[left] >= leftMax) {
        //             leftMax = height[left];
        //         } else {
        //             water += leftMax - height[left];
        //         }
        //         left++;
        //     } else {
        //         if (height[right] >= rightMax) {
        //             rightMax = height[right];
        //         } else {
        //             water += rightMax - height[right];
        //         }
        //         right--;
        //     }
        // }
        // return water;

        int n=height.length;
        int totalwater=0;
        int[] leftMax=new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }
        int[] RightMax=new int[n];
        RightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            RightMax[i]=Math.max(RightMax[i+1],height[i]);
        }

        for(int i=0;i<n;i++){
            totalwater+=Math.min(leftMax[i],RightMax[i])-height[i];
        }

        return totalwater;

    }
}