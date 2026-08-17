class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap();
        for(String s : strs) {
            int[] index = new int[26];
            for (char c : s.toCharArray()) {
                index[c - 'a']++;
            }

            String key = Arrays.toString(index);

            map.put(key, map.getOrDefault(key, new ArrayList<String>()));
            map.get(key).add(s);
        }

        List<List<String>> soln = new ArrayList<List<String>>();
        for(Map.Entry<String, ArrayList<String>> e : map.entrySet()) {
            soln.add(e.getValue());
        }
        return soln;
    }
}
