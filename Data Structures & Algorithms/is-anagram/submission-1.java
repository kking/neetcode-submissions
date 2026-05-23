class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return hashTableAnagram(s, t);
    }

    public boolean hashTableAnagram(String s, String t) {
        Hashtable<Character, Integer> table = new Hashtable<>();
        // populate table with string s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (table.containsKey(c)) {
                table.replace(c, table.get(c)+1);
            }
            else {
                table.put(c, 1);
            }
        }
        // depopulate table with string t
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!table.containsKey(c)) {
                return false;
            }
            if (!table.remove(c, 1)) {
                table.replace(c, table.get(c)-1);
            }
        }
        return table.isEmpty();
    }
}
