/**
 * Offer03
 */
public class Offer03 {

    /**
     * 方法1: 利用正负符号作为判断
     * 
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int tmp = (nums[i] < 0) ? -nums[i] : nums[i];
            if (nums[tmp] < 0) {
                return tmp;
            } else {
                nums[tmp] *= -1;
            }
        }
        return 0;
    }

    /**
     * 方法2:交换
     * 利用了下标冲突,原书有思路
     * @param args
     */
    public static int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                } else {
                    int tmp = nums[i];
                    nums[i] = nums[tmp];
                    nums[tmp] = tmp;
                    break;
                }
            }
        }
        return -1;
    }

    /**
     * 其他方法: 哈希,排序+扫描
     */

    public static void main(String[] args) {
        int[] nums = { 2, 2, 0, 3, 1, 0, 2, 5, 3 };
        System.out.println(findRepeatNumber2(nums));
    }

}
