class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] key = new int[26];
            for (char c : s.toCharArray()) {
                key[c - 'a']++;
            }
            String index = Arrays.toString(key);
            if (!map.containsKey(index)) map.put(index, new ArrayList<String>());
            map.get(index).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
