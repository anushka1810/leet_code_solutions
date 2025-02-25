class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> deviceCounts = new ArrayList<>();
        
        for (String row : bank) {
            int count = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
            if (count > 0) {
                deviceCounts.add(count);
            }
        }
        
        if (deviceCounts.size() < 2) {
            return 0;
        }
        int totalBeams = 0;
        for (int i = 0; i < deviceCounts.size() - 1; i++) {
            totalBeams += deviceCounts.get(i) * deviceCounts.get(i + 1);
        }
        
        return totalBeams;
    }
}