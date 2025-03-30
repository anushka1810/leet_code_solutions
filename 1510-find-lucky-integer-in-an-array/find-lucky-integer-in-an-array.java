class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        // Count occurrences of each number
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int luckyNumber = -1;
        
        // Check for lucky numbers
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (num == count) {
                luckyNumber = Math.max(luckyNumber, num);
            }
        }
        
        return luckyNumber;
    }
}