import java.util.*;

public class CountKDistinctSubstrings {

    private static int atMostKDistinct(String s, int k) {
        int n = s.length();
        int left = 0, res = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }

            
            res += (right - left + 1);
        }
        return res;
    }

    
    public static int countExactlyKDistinct(String s, int k) {
        if (k == 0) return 0;
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    public static void main(String[] args) {
        System.out.println(countExactlyKDistinct("pqpqs", 2));      
        System.out.println(countExactlyKDistinct("aabacbebebe", 3));
        System.out.println(countExactlyKDistinct("a", 1));      
        System.out.println(countExactlyKDistinct("abc", 3));    
        System.out.println(countExactlyKDistinct("abc", 2));    
    }
}
