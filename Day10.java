import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);

        
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = {""};
        String[] strs3 = {"a"};
        String[] strs4 = {"abc", "bca", "cab", "xyz", "zyx", "yxz"};
        String[] strs5 = {"abc", "def", "ghi"};

        System.out.println(groupAnagrams(strs1));
        System.out.println(groupAnagrams(strs2));
        System.out.println(groupAnagrams(strs3));
        System.out.println(groupAnagrams(strs4));
        System.out.println(groupAnagrams(strs5));
    }
}
