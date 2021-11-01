package Offer;

import java.util.HashSet;

public class Offer05单词长度的最大乘积 {
    public static void main(String[] args) {
        String[] words = {"abcw","baz","foo","bar","fxyz","abcdef"};
        int res = maxProductII(words);
        System.out.println(res);
    }

    /**
     * 使用位运算进行优化
     * @param words
     * @return
     */
    public static int maxProductII(String[] words){
        int n = words.length;
        int[] masks = new int[n];//用来存储单词的掩码
        int[] lens = new int[n];//用来存储单词的长度

        int bitmask;
        for (int i=0;i<n;i++){
            bitmask = 0;
            for (char ch : words[i].toCharArray()) {
                bitmask |= (1<<bitNumber(ch));
            }
            masks[i] = bitmask;
            lens[i] = words[i].length();
        }
        int res = 0;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if ((masks[i]&masks[j])==0){
                    //无公共字符
                    res = Math.max(res, lens[i]*lens[j]);
                }
            }
        }
        return res;
    }

    public static int bitNumber(char ch){
        return ch-'a';
    }

    /**
     * 暴力法
     * @param words
     * @return
     */
    public static int maxProduct(String[] words) {
        int res = 0;
        for (int i=0;i<words.length-1;i++){
            String word1 = words[i];
            for (int j=i+1;j<words.length;j++){
                String word2 = words[j];
                if (!hasSameCharacter(word1, word2)){
                    res = Math.max(res, word1.length()*word2.length());
                }
            }
        }
        return res;
    }

    public static boolean hasSameCharacter(String word1, String word2){
        for (char ch : word1.toCharArray()) {
            if (word2.indexOf(ch)!=-1){
                return true;
            }
        }
        return false;
    }
}
