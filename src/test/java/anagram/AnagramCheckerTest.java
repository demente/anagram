package anagram;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnagramCheckerTest {

    private final String input1;
    private final String input2;
    private final boolean expectedResult;

    public AnagramCheckerTest(String input1, String input2, boolean expectedResult) {
        this.input1 = input1;
        this.input2 = input2;
        this.expectedResult = expectedResult;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Listen", "Silent", true},
                {"abc", "abcd", false},
                {"Astronomer", "Moon starer", true},
                {"Church of Scientology", "rich-chosen goofy cult", true},
                {"abc", "ABC", true},
        });
    }

    @Test
    public void testAreAnagrams() {
        assertEquals(expectedResult, AnagramChecker.areAnagrams(input1, input2));
    }
}
