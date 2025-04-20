class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> l = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return l;
        }

        int start = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    l.add(String.valueOf(start));
                } else {
                    l.add(start + "->" + nums[i - 1]);
                }
                start = nums[i]; 
            }
        }
        if (start == nums[len - 1]) {
            l.add(String.valueOf(start));
        } else {
            l.add(start + "->" + nums[len - 1]);
        }

        return l;
    }
}
