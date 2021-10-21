package Offer;

public class Offer05 {
    public static void main(String[] args) {
        String s = "We are happy.  ";
        String res = replaceSpace(s);
        System.out.println(res);
    }

    /**
     * 替换字符串中的所有空格
     * @param s
     * @return
     */
    public static String replaceSpace(String s){
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
