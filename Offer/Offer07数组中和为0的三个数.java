package Offer;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，
 * 使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1fGaJU
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer07数组中和为0的三个数 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i=0;i<n;i++){
            if (nums[i]>0){
                break;
            }
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int j = i+1, k = n-1;
            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if (sum == 0){
                    Integer[] ans = {i,j,k};
                    res.add(Arrays.asList(ans));
                }else if (sum > 0){
                    while (nums[k-1]==nums[k]){
                        k--;
                    }
                    k--;
                }else if (sum < 0){
                    while (nums[j+1]==nums[j]){
                        j++;
                    }
                    j++;
                }
            }
        }
        return res;
    }
}
