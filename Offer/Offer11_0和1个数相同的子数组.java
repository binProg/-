package Offer;

import java.util.HashMap;

public class Offer11_0和1个数相同的子数组 {
    public static void main(String[] args) {
//        int[] nums = {0,0,1,0,0,0,1,1};
        int[] nums = {0,1,0};
        int len = findMaxLength(nums);
        System.out.println(len);
    }

    public static int findMaxLength(int[] nums){
        //前缀和
        //相同的0和1的最长子数组
        //将0变为-1，即求和为0的最长子数组的长度
        HashMap<Integer, Integer> map = new HashMap<>();
        int counter = 0;//记录前缀和
        int len = 0;
        map.put(counter, -1);
        for (int i=0;i<nums.length;i++){
            if (nums[i] == 1){
                counter++;
            }else {
                counter--;
            }
            if (map.containsKey(counter)){
                int preIdx = map.get(counter);
                len = Math.max(len, i-preIdx);
            }else {
                map.put(counter, i);
            }
        }
        return len;
    }
}
