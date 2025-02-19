class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int totalTime = 0;
        char[] garbageTypes = {'M', 'P', 'G'};
        
        for (char type : garbageTypes) {
            int lastHouse = -1;
            int collectionTime = 0;
            
            for (int i = 0; i < garbage.length; i++) {
                int count = countGarbage(garbage[i], type);
                if (count > 0) {
                    lastHouse = i;
                    collectionTime += count;
                }
            }
            
            if (lastHouse > 0) {
                for (int i = 0; i < lastHouse; i++) {
                    collectionTime += travel[i];
                }
            }
            
            totalTime += collectionTime;
        }
        
        return totalTime;
    }
    
    private int countGarbage(String houseGarbage, char type) {
        int count = 0;
        for (char c : houseGarbage.toCharArray()) {
            if (c == type) {
                count++;
            }
        }
        return count;
    }
}