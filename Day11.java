import java.util.*;

public class StringPermutations {
    
    public static List<String> permute(String s) {
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        backtrack(chars, new StringBuilder(), used, result);
        return result;
    }

    private static void backtrack(char[] chars, StringBuilder path, boolean[] used, List<String> result) {
        if (path.length() == chars.length) {
            result.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
        
            if (used[i]) continue;

            
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            path.append(chars[i]);
            backtrack(chars, path, used, result);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
     
        System.out.println(permute("abc"));  
        System.out.println(permute("aab"));  
        System.out.println(permute("aaa"));  
        System.out.println(permute("a"));   
        System.out.println(permute("abcd")); 
    }
}
