class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s1.length() - 1; i++) {
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        int i = 0;
        int j = s1.length() - 2;
        while (j < s2.length() - 1) {
            j++;
            map2.put(s2.charAt(j), map2.getOrDefault(s2.charAt(j), 0) + 1);
            if (map1.equals(map2)) return true;
            if (map2.get(s2.charAt(i)) == 1) map2.remove(s2.charAt(i));
            else map2.put(s2.charAt(i), map2.get(s2.charAt(i)) - 1);
            i++;
        }
        return false;
    }
}
