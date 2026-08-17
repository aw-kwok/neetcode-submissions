class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> soln = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            StringBuilder num = new StringBuilder();
            while (str.charAt(i) != '#') {
                num.append(str.charAt(i));
                i++;
            }
            i++;
            int strSize = Integer.valueOf(num.toString());
            soln.add(str.substring(i, i + strSize));
            i = i + strSize;
        }
        return soln;
    }
}
