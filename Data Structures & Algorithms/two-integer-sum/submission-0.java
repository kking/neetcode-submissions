class Solution {
    // aim for O(n) time and O(n) space
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target-nums[i];
            if (table.containsKey(difference)) {
                return new int[]{table.get(difference), i};
            }
            table.put(nums[i], i);
        }
        return new int[]{-1,-1}; // fail
    }
}