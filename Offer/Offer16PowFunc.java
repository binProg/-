package Offer;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 */
public class Offer16PowFunc {
    public static void main(String[] args) {
        double x = 2.10000;
        int n = 3;
        double ret = myPow(x, n);
        System.out.println(ret);
    }

    public static double myPow(double x, int n) {
        //使用快速幂方法
        if (x==0){
            return 0;
        }
        //n为负数
        long b = n;//避免越界
        if (b<0){
            x = 1/x;
            b = -b;
        }
        double ret = 1.0;
        while (b>0){
            if ((b&1)>0){
                ret *= x;
            }
            x *= x;
            b = (b>>1);
        }
        return ret;
    }
}