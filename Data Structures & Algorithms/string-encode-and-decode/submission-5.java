class Solution {

    public String encode(List<String> strs) {
        String encoded = "";
        for (String s : strs) {
            encoded = encoded + s.length() + '#' + s;
        }
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> soln = new ArrayList();

        int i = 0;
        while (i < str.length()) {
            // read String until '#' - this is the length
            String len = "";
            while (str.charAt(i) != '#') {
                len = len + str.charAt(i);
                i++;
            }
            i++;
            int intLen = Integer.valueOf(len);

            // substring the String from index of '#' + 1 to length
            soln.add(str.substring(i, i + intLen));
            i = i + intLen;
        }
        
        return soln;
    }
}
