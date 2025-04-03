class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        int[] maxPrefix = new int[n];
        int[] maxSuffix = new int[n];

        maxPrefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxPrefix[i] = Math.max(maxPrefix[i - 1], nums[i]);
        }

        maxSuffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxSuffix[i] = Math.max(maxSuffix[i + 1], nums[i]);
        }

        long maxValue = 0;
        for (int j = 1; j < n - 1; j++) {
            long value = ((long) maxPrefix[j - 1] - nums[j]) * maxSuffix[j + 1];
            maxValue = Math.max(maxValue, value);
        }

        return maxValue;
    }
}
