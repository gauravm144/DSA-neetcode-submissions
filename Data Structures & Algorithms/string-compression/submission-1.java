class Solution {
    public int compress(char[] chars) {
        int i = 0, j = 0;
        char inextchar = chars[0];
        int count = 0;

        while (j < chars.length) {

            if (inextchar == chars[j]) {
                count++;
            } else {

                // write character
                chars[i++] = inextchar;

                // write count
                if (count != 1) {
                    String tmp = "" + count;

                    for (int k = 0; k < tmp.length(); k++) {
                        chars[i++] = tmp.charAt(k);
                    }
                }

                // new group
                inextchar = chars[j];
                count = 1;
            }

            j++;
        }

        // process last group
        chars[i++] = inextchar;

        if (count != 1) {
            String tmp = "" + count;

            for (int k = 0; k < tmp.length(); k++) {
                chars[i++] = tmp.charAt(k);
            }
        }

        return i;
    }
}