import java.util.*;

class Solution {

    public List<String> findAndReplacePattern(
            String[] words, String pattern) {

        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {

        int[] pToW = new int[26];
        int[] wToP = new int[26];

        Arrays.fill(pToW, -1);
        Arrays.fill(wToP, -1);

        for (int i = 0; i < pattern.length(); i++) {

            int p = pattern.charAt(i) - 'a';
            int w = word.charAt(i) - 'a';

            // Existing pattern mapping
            if (pToW[p] != -1 && pToW[p] != w) {
                return false;
            }

            // Existing word mapping
            if (wToP[w] != -1 && wToP[w] != p) {
                return false;
            }

            pToW[p] = w;
            wToP[w] = p;
        }

        return true;
    }
}