package anagram;

public class AnagramChecker {

    private static final int ASCII_CHAR_AMOUNT = 128;

    public static boolean areAnagrams(String str1, String str2) {
        str1 = str1.replaceAll("[\\s-]", "").toLowerCase();
        str2 = str2.replaceAll("[\\s-]", "").toLowerCase();


        if (str1.length() != str2.length()) {
            return false;
        }
        int[] characterFrequency = new int[ASCII_CHAR_AMOUNT];

        for (char c : str1.toCharArray()) {
            characterFrequency[c]++;
        }


        for (char c : str2.toCharArray()) {
            if (characterFrequency[c] == 0) {
                return false;
            }
            characterFrequency[c]--;
        }

        return true;
    }

}
