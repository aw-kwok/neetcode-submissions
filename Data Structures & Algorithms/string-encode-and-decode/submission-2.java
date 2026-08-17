class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int length = str.length();
            sb.append(length).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> soln = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            soln.add(str.substring(i, j));
            i = j;
        }
        return soln;
    }
}
