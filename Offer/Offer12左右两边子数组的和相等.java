package Offer;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0，因为在下标的左侧不存在元素。
 * 这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1
 */
public class Offer12左右两边子数组的和相等 {
    public static void main(String[] args) {
        int[] nums = {-1,-1,-1,-1,-1,0};
        int res = pivotIndex(nums);
        System.out.println(res);
    }

    /**
     * 前缀和
     * 1.计算total
     * 2.nums[i]左边数组之和sum
     * 3.若左右子数组之和相等，则有2*sum+nums[i]=total
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums){
        int sum = 0;
        int total = Arrays.stream(nums).sum();
        for (int i=0;i<nums.length;i++){
            if (sum*2 + nums[i] == total){
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
