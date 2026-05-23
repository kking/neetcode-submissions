class Solution {
    // aim for O(m*n) time and O(m) space, 
    // where m is number of strings and n is length of longest string
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> out = new LinkedList<List<String>>();
        populateList(out, strs);
        return out;
    }

    private void populateList(List<List<String>> list, String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            List<String> sublist = new LinkedList<String>();
            populateSublist(sublist, strs[i], strs);
            if (!list.contains(sublist)) {
                list.add(sublist);
            }
        }
    }

    private void populateSublist(List<String> sublist, String target, String[] strs) {
        for (String str : strs) {
            if (isAnagram(target, str)) {
                sublist.add(str);
            }
        }
    }

    private boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> map = new Hashtable<>();
        // populate map
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i), c2 = str2.charAt(i);
            if (map.containsKey(c1)) {
                map.replace(c1, map.get(c1)+1);
            }
            else {
                map.put(c1, 1);
            }
            if (map.containsKey(c2)) {
                map.replace(c2, map.get(c2)-1);
            }
            else {
                map.put(c2, -1);
            }
        }
        // check map
        for (int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
