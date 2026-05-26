class Solution {
    // aim for O(m*n) time and O(m) space, 
    // where m is number of strings and n is length of longest string
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> out = new LinkedList<List<String>>();
        populateList(out, strs);
        return out;
    }

    private void populateList(List<List<String>> list, String[] strs) {
        // 1. pass through m strings
        // 2. for each string, compute in O(n)
        // 3. use structure to lookup/group in O(1)
        Map<String, List<String>> stringMap = new Hashtable<>();
        for (String str : strs) {
            populateMap(stringMap, str);
        }
        // add values/sublists from map into list
        for (List<String> sublist : stringMap.values()) {
            list.add(sublist);
        }
    }

    private void populateMap(Map<String, List<String>> map, String str) {
        String key = computeKey(str);
        if (map.containsKey(key)) {
            map.get(key).add(str);
        }
        else {
            List<String> sublist = new LinkedList<>();
            sublist.add(str);
            map.put(key, sublist);
        }
    }

    private String computeKey(String str) {
        int[] frequencyTable = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            frequencyTable[index]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : frequencyTable) {
            sb.append(i).append('-');
        }
        return sb.toString();
    }
}
