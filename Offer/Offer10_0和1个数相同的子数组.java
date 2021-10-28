package Offer;

public class Offer10_0和1个数相同的子数组 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,1};
        int res = findMaxLength(nums);
        System.out.println(res);
    }

    public static int findMaxLength(int[] nums){
        int[] preSum_0 = new int[nums.length+1];
        int[] preSum_1 = new int[nums.length+1];
        for (int i=1;i<=nums.length;i++){
            if (nums[i-1] == 0){
                preSum_0[i] = preSum_0[i-1]+1;
                preSum_1[i] = preSum_1[i-1];
            }else {
                preSum_0[i] = preSum_0[i-1];
                preSum_1[i] = preSum_1[i-1]+1;
            }
        }
        int len = 0;
        for (int i=1;i<=nums.length;i++){
            for (int j=0;j<i;j++){
                if (preSum_0[i]-preSum_0[j] == preSum_1[i]-preSum_1[j]){
                    len = Math.max(i-j,len);
                }
            }
        }
        return len;
    }
}
