import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  final private Solution sol = new Solution();
  @Test
  void findWordsExample1() {
    assertEquals(
        List.of("oath","eat"),
        sol.findWords(
            new char[][]{
                new char[]{'o','a', 'a', 'n'},
                new char[]{'e', 't', 'a', 'e'},
                new char[]{'i', 'h', 'k', 'r'},
                new char[]{'i', 'f', 'l', 'v'}
            },
            new String[]{"oath", "pea", "eat", "rain"}
        )
    );
  }
  @Test
  void findWordsExample2() {
    assertEquals(
        List.of(),
        sol.findWords(
            new char[][]{
                new char[]{'a','b'},
                new char[]{'c', 'd'}
            },
            new String[]{"abcd"}
        )
    );
  }
}