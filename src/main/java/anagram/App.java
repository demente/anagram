package anagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {

    private static final HashMap<String, List<String>> anagrams = new HashMap<String, List<String>>();

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Function function = InputCLI.functionInput();
        switch (function) {
            case ANAGRAM_CHECKER:
                AnagramInput input = InputCLI.anagramCheckInput();
                boolean areAnagrams = AnagramChecker.areAnagrams(input.getFirst(), input.getSecond());
                if (areAnagrams) {
                    storeAnagrams(input);
                    System.out.println("Provided strings are anagrams!");
                    run();

                } else {
                    System.out.println("Provided strings are NOT anagrams!");
                    run();
                }
                break;
            case ANAGRAM_LIST:
                String listInput = InputCLI.anagramListInput();
                List<String> anagramList = getAnagrams(listInput);
                if (anagramList != null) {
                    anagramList.forEach(System.out::println);
                }
                run();
                break;
            case CLOSE:
            default:
                //Do nothing and exit
        }
    }

    private static void storeAnagrams(AnagramInput input) {
        storeAnagrams(input.getFirst(), input.getSecond());
        storeAnagrams(input.getSecond(), input.getFirst());
    }

    private static void storeAnagrams(String first, String second) {
        anagrams.putIfAbsent(first, new ArrayList<String>());
        anagrams.get(first).add(second);
    }

    public static List<String> getAnagrams(String input) {
        return anagrams.get(input);
    }
}
