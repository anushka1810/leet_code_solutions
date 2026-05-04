class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;

        if(n>m) return findMedianSortedArrays(nums2,nums1);
        int low=0,high=n;

        int left=(m+n+1)/2;

        while(low<=high){
            int mid=low+(high-low)/2;

            int no_of_ele_1=mid;
            int no_of_ele_2=left-mid;

            int left_1=(no_of_ele_1==0)?Integer.MIN_VALUE:nums1[no_of_ele_1-1];
            int left_2=(no_of_ele_2==0)?Integer.MIN_VALUE:nums2[no_of_ele_2-1];

            int right_1=(no_of_ele_1==n)?Integer.MAX_VALUE:nums1[no_of_ele_1];
            int right_2=(no_of_ele_2==m)?Integer.MAX_VALUE:nums2[no_of_ele_2];

            if(left_1<=right_2 && left_2<=right_1){
                if((m+n)%2==0) return (Math.max(left_1,left_2)+Math.min(right_1,right_2))/2.0;
                return Math.max(left_1,left_2);
            }else if(left_1>right_2) high=mid-1;
            else low=mid+1;
        }

        return -1;
    }
}