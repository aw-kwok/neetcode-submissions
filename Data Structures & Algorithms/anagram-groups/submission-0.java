class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String str : strs) {
            int[] key = new int[26];
            char[] arr = str.toCharArray();
            for (char c : arr) {
                key[c - 'a']++;
            }
            String index = Arrays.toString(key);
            if (!map.containsKey(index)) {
                map.put(index, new ArrayList<String>());
            }
            map.get(index).add(str);
        }
        return new ArrayList(map.values());
    }
}
