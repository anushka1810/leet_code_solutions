class Solution {
    public int[] searchRange(int[] nums, int target) {

        int l = 0, h = nums.length - 1;

        while (l <= h) {

            int mid = l + (h - l) / 2;

            if (nums[mid] == target) {

                int first = mid, last = mid;

                while (first >= 0 && nums[first] == target) {
                    first--;
                }

                while (last < nums.length && nums[last] == target) {
                    last++;
                }

                return new int[]{first + 1, last - 1};
            }

            else if (nums[mid] > target) h = mid - 1;
            else l = mid + 1;
        }

        return new int[]{-1, -1};
    }
}