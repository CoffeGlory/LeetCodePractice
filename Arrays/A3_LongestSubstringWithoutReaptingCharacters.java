import java.util.HashSet;
import java.util.Set;

public class A3_LongestSubstringWithoutReaptingCharacters {
    public static void main(String[] args) {
        
    }
/**
 * gpt solution, using hashset to record each pair and return the longest pair
 * @param s
 * @return
 */
public int lengthOfLongestSubstring(String s) {
    Set<Character> seen = new HashSet<>();
    int left = 0, right = 0, maxLen = 0;

    while (right < s.length()) {
        char c = s.charAt(right);
        //if current has exist before, compare is it length to maximum length
        if (!seen.contains(c)) {
            seen.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        } else {
            //if repeat
            seen.remove(s.charAt(left));
            left++;
        }
    }
    return maxLen;
}

}
