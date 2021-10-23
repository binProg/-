package Offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个\*递增\*排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 */
public class Offer11_minArray {
    public static void main(String[] args) {
        int[] nums1 = {3,4,5,1,2};
        int res1 = minArray(nums1);
        System.out.println(res1);
        int[] nums2 = {2,2,2,0,1};
        int res2 = minArray(nums2);
        System.out.println(res2);
    }

    public static int minArray(int[] nums){
        int i = 0, j = nums.length-1;
        while (nums[i]>=nums[j]){
            int mid = i+(j-i)/2;
            if (nums[i] == nums[mid] && nums[j] == nums[mid]){
                //此时，无法分辨最小值在mid的左边还是右边，只能遍历
                return traverse(nums, i, j);
            }else if (nums[mid] >= nums[i]){
                //则mid及其左边部分是递增有序的，最小值应该在mid的右边
                i = mid + 1;
            }else if (nums[mid] <= nums[j]){
                //则mid及其右边部分是递增有序的，最小值应该在mid或者mid的左边
                j = mid;
            }
        }
        return nums[i];
    }

    public static int traverse(int[] nums, int left, int right){
        int min = nums[left];
        for (int i=left+1;i<=right;i++){
            if (nums[i]<min){
                min = nums[i];
            }
        }
        return min;
    }
}
