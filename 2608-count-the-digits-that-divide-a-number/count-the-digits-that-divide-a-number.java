class Solution {
    public int countDigits(int num) {
        int org = num;
        int count = 0;
        while (num > 0) {
            int d = num % 10;
            if (d != 0 && org % d == 0) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
}