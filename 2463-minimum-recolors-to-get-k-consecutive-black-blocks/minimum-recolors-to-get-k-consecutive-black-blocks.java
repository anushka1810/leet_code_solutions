class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minOperations = Integer.MAX_VALUE;
        int whiteCount = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }

        minOperations = whiteCount;

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--;
            }
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }

            minOperations = Math.min(minOperations, whiteCount);
            if (minOperations == 0) {
                return 0;
            }
        }

        return minOperations;
    }
}
