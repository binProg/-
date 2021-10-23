package Offer;

import java.util.Arrays;

public class Offer21调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        nums = exchange(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] exchange(int[] nums){
        int n = nums.length;
        int left = 0, right = n-1;
        while (left<right){
            while (left<right&&nums[left]%2==1){
                ++left;
            }
            while (left<right&&nums[right]%2==0){
                --right;
            }
            if (left<right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        return nums;
    }
}
