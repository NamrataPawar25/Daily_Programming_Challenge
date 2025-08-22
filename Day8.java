public class ReverseWords  {

    public static String reverseWords(String s) {
        s = s.trim();

        String[] words = s.split("\\s+");

        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));        
        System.out.println(reverseWords("  hello world  "));        
        System.out.println(reverseWords("a good   example"));       
        System.out.println(reverseWords("    "));               
        System.out.println(reverseWords("word"));                   
    }
}
