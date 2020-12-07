import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArray(final int[] nums) {
        return quickSort(nums);
    }

    // 调Arrays的api, 本质上是快排
    public int[] iLikeAPI(final int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 选择排序 在未排序数组中选择最小的插入到已排序数组最后 时: O(N^2) 空: O(1)
     * 
     * @param nums
     * @return
     */
    public int[] selectSort(final int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIdx = i, j = i;
            for (; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            final int tmp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = tmp;
        }
        return nums;
    }

    /**
     * 插入排序 每次将未排序的第一个数插入到已排序的合适位置
     * 
     * @param nums
     * @return
     */
    public int[] insertSort(final int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            final int tmp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > tmp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = tmp;
        }
        return nums;
    }

    /**
     * 归并排序 将两个有序数组进行合并
     * 
     * @param nums
     * @return
     */
    public int[] mergeSort(final int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int minIdx = (int) Math.floor(nums.length / 2);

        int[] left = Arrays.copyOfRange(nums, 0, minIdx);
        left = mergeSort(left);

        int[] right = Arrays.copyOfRange(nums, minIdx, nums.length);
        right = mergeSort(right);

        int[] ans = mergeTwoSortedArray(left, right);
        // System.out.println(Arrays.toString(ans));
        return ans;
    }

    private int[] mergeTwoSortedArray(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length + nums2.length];
        int i = 0;
        int p1 = 0;
        int p2 = 0;
        while (p1 != nums1.length && p2 != nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                ans[i++] = nums1[p1++];
            } else {
                ans[i++] = nums2[p2++];
            }
        }
        while (p1 != nums1.length) {
            ans[i++] = nums1[p1++];
        }
        while (p2 != nums2.length) {
            ans[i++] = nums2[p2++];
        }
        return ans;
    }

    /**
     * 快排
     *   https://visualgo.net/zh/sorting
     * @param nums
     * @return
     */
    public int[] quickSort(final int[] nums) {
        quickSortHelper(nums, 0, nums.length);
        return nums;
    }

    private void quickSortHelper(int[] nums, int left, int right) {
        if (right - left < 2) {
            return;
        }

        int partition = left;
        int storePos = partition+1;
        for (int i = storePos; i < right; i++) {
            if (nums[i] < nums[partition]) {
                int tmp = nums[storePos];
                nums[storePos++] = nums[i];
                nums[i] = tmp;
            }
        }
        {
            // 交换(轴心点,存储指数-1)
            int tmp = nums[storePos - 1];
            nums[storePos - 1] = nums[partition];
            nums[partition] = tmp;
            partition = storePos - 1;
        }
        quickSortHelper(nums, left, partition);
        quickSortHelper(nums, partition + 1, right);
    }
}
// @lc code=end
