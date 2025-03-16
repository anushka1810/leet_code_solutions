class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int n2 = n * n;
        
        // Calculate the expected sum and sum of squares
        long sumExpected = (long) n2 * (n2 + 1) / 2;
        long sumSquaresExpected = (long) n2 * (n2 + 1) * (2 * n2 + 1) / 6;
        
        // Variables to store the actual sum and sum of squares from the grid
        long sumActual = 0;
        long sumSquaresActual = 0;
        
        // Traverse the grid to calculate actual sums and sum of squares
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                sumActual += num;
                sumSquaresActual += (long) num * num;
            }
        }
        
        // Calculate the differences
        long diffSum = sumExpected - sumActual;  // b - a
        long diffSumSquares = sumSquaresExpected - sumSquaresActual;  // b^2 - a^2
        
        // Solve for b and a using the derived equations
        long sumAB = diffSumSquares / diffSum;  // b + a
        
        int a = (int) ((sumAB - diffSum) / 2);  // a (repeated number)
        int b = (int) (a + diffSum);  // b (missing number)
        
        return new int[] {a, b};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] grid1 = {{1, 3}, {2, 2}};
        int[] result1 = sol.findMissingAndRepeatedValues(grid1);
        System.out.println("Result: [" + result1[0] + ", " + result1[1] + "]"); // [2, 4]
        
        int[][] grid2 = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};
        int[] result2 = sol.findMissingAndRepeatedValues(grid2);
        System.out.println("Result: [" + result2[0] + ", " + result2[1] + "]"); // [9, 5]
    }
}
