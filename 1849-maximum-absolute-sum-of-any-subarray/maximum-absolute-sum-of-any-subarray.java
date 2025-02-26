class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0, minSum = 0;
        int currentMax = 0, currentMin = 0;
        int result = 0;

        for (int num : nums) {
            currentMax = Math.max(currentMax + num, num);
            currentMin = Math.min(currentMin + num, num);

            maxSum = Math.max(maxSum, currentMax);
            minSum = Math.min(minSum, currentMin);

            result = Math.max(result, Math.max(Math.abs(maxSum), Math.abs(minSum)));
        }

        return result;
    }
}