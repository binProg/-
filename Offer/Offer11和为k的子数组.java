package Offer;

public class Offer11和为k的子数组 {
    /**
     * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        int res = subarraySum(nums, k);
        System.out.println(res);
    }

    /**
     * 思路：前缀和 + 双指针
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k){
        int[] preSum = new int[nums.length+1];
        for (int i=1;i<preSum.length;i++){
            preSum[i] = preSum[i-1]+nums[i-1];
        }
        int res = 0;
        for (int i=1;i<preSum.length;i++){
            for (int j=0;j<i;j++){
                if (preSum[i] - preSum[j] == k){
                    res++;
                }
            }
        }
        return res;
    }
}
