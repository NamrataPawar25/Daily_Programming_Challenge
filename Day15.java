import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

   
    public int lengthOfLongestSubstring(String s) {
        
        if (s == null || s.length() == 0) {
            return 0;
        }

    
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        int maxLength = 0;


        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

           
            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(left));
                left++;
            }

            
            charSet.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstring solution = new LongestSubstring();

        
        String s1 = "abcabcbb";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s1)); 
        System.out.println("-------------------------");

        String s2 = "bbbbb";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s2)); 
        System.out.println("-------------------------");

        String s3 = "pwwkew";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s3)); 
        System.out.println("-------------------------");

        String s4 = "abcdefgh";
        System.out.println("Input: " + s4);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s4)); 
        System.out.println("-------------------------");
        
        String s5 = "a";
        System.out.println("Input: " + s5);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s5)); 
        System.out.println("-------------------------");
    }
}
