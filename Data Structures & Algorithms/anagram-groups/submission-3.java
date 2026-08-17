class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] key = new int[26];
            for (char c : str.toCharArray()) {
                key[c - 'a']++;
            }
            String keyString = Arrays.toString(key);
            map.putIfAbsent(keyString, new ArrayList<String>());
            map.get(keyString).add(str);
        }
        List<List<String>> soln = new ArrayList<>();
        for (Map.Entry<String,List<String>> e : map.entrySet()) {
            soln.add(e.getValue());
        }
        return soln;
    }
}
