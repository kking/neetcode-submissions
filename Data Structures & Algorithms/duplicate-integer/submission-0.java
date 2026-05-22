class Solution {
    public boolean hasDuplicate(int[] nums) {
        return setDuplicate(nums, new HashSet());
    }

    public boolean setDuplicate(int[] nums, Set set) {
        for (int i: nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }
}