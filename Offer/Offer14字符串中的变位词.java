package Offer;

import java.util.HashMap;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 */
public class Offer14字符串中的变位词 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ooolleoooleh";
        boolean res = checkInclusion(s1, s2);
        System.out.println(res);
    }

    /**
     * 判断s2是否包含s1的字符排列
     * 使用滑动窗口算法来判断
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2){
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> wind = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0)+1);
        }

        int left = 0, right = 0;
        int valid = 0;//s2中长度为s1的子串中的满足need条件的有效字符数量
        while (right<s2.length()){
            char ch = s2.charAt(right);
            right++;
            //对窗口进行一系列的更新操作
            if (need.containsKey(ch)){
                wind.put(ch, wind.getOrDefault(ch, 0)+1);
                if (wind.get(ch).equals(need.get(ch))){
                    valid++;
                }
            }
            while (right-left>=s1.length()){
                if (valid == need.size()){
                    return true;
                }
                char del = s2.charAt(left);
                left++;
                //进行窗口内的一系列更新
                if (need.containsKey(del)){
                    if (wind.get(del).equals(need.get(del))){
                        valid--;
                    }
                    wind.put(del, wind.get(del)-1);
                }
            }
        }
        return false;
    }
}
