package cff;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LengthOfLongestSubstring extends Evaluator{
    @Override
    protected List<IO> getTestCase() {
        return List.of(new IO("abcabcbb", 3), new IO("bbbbb", 1), new IO("pwwkew", 3));
    }

    @Override
    protected Object getResult(Object input) {
        return sol2((String) input);
    }

    public int sol1(String s) {
        int left =0, maxLen =0;
        Map<Character, Integer> lastSeen = new HashMap<>();

        for (int right = 0; right < s.length(); right ++) {
            var currentChar = s.charAt(right);
            if (lastSeen.containsKey(currentChar)) {
                left = Math.max(left, lastSeen.get(currentChar) + 1);
            }

            lastSeen.put(currentChar, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public int sol2(String s) {
        int left =0, maxLen =0;
        int[] lastSeen = new int[128];

        for (int right = 0; right < s.length(); right ++) {
            var currentChar = s.charAt(right);
            left = Math.max(left, lastSeen[currentChar]);
            lastSeen[currentChar] = right + 1;
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        new LengthOfLongestSubstring().evaluate();
    }
}
