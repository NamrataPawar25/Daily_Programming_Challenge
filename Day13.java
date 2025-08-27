public class LongestPalindromicSubstring {
    
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0, maxLen = 1;
        
        for (int i = 0; i < s.length(); i++) {
           
            int len1 = expandAroundCenter(s, i, i);
            if (len1 > maxLen) {
                maxLen = len1;
                start = i - (len1 - 1) / 2;
            }
          
            int len2 = expandAroundCenter(s, i, i + 1);
            if (len2 > maxLen) {
                maxLen = len2;
                start = i - (len2 / 2) + 1;
            }
        }
        
        return s.substring(start, start + maxLen);
    }
    
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    
  
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); 
        System.out.println(longestPalindrome("cbbd"));  
        System.out.println(longestPalindrome("a"));     
        System.out.println(longestPalindrome("aaaa"));  
        System.out.println(longestPalindrome("abc"));   
    }
}
