package Offer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。
 * 不考虑答案输出的顺序。
 */
public class Offer15字符串中的所有变位词 {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> res = findAnagrams(s, p);
        for (int idx : res) {
            System.out.print(idx+" ");
        }
    }

    public static List<Integer> findAnagrams(String s, String p) {
        //滑动窗口
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> wind = new HashMap<>();

        for (char ch: p.toCharArray()){
            need.put(ch, need.getOrDefault(ch, 0)+1);
        }

        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new LinkedList<>();
        while (right<s.length()){
            char ch = s.charAt(right);
            right++;
            //更新窗口
            if (need.containsKey(ch)){
                wind.put(ch, wind.getOrDefault(ch, 0)+1);
                if (wind.get(ch).equals(need.get(ch))){
                    valid++;
                }
            }
            while (right-left>=p.length()){
                if (valid == need.size()){
                    res.add(left);
                }
                char del = s.charAt(left);
                left++;
                //更新窗口
                if (need.containsKey(del)){
                    if (wind.get(del).equals(need.get(del))){
                        valid--;
                    }
                    wind.put(del, wind.get(del)-1);
                }
            }
        }
        return res;
    }
}
