public class DnaPatternSearch {
    public static void search(String text, String pattern) {
        int M = pattern.length();
        int N = text.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) break;
            }
            if (j == M) {
                System.out.println("Pattern found at index: " + i);
            }
        }
    }

    public static void main(String[] args) {
        String dna = "ACGTACGTGACGTAGCT";
        String pattern = "CGT";
        search(dna, pattern);
    }
}