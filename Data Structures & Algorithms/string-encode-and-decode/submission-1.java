class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            int length = s.length();
            res.append(s.length()).append("#").append(s);
        }
        return res.toString();
    }
    //4#neet4#code4#love3#you
    public List<String> decode(String str) {
        int i = 0;
        List<String> soln = new ArrayList<>();
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int size = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + size;
            soln.add(str.substring(i, j));
            i = j;
        }
        return soln;
    }
}
