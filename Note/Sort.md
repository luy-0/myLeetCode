# 排序算法

## 选择排序

> 在数组未排序部分中，选择最小的元素，插入到已排序部分的最后。

时间复杂度$O(N^2)$

空间复杂度$O(1)$

```java
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
```

## 插入排序

> 每次将未排序的第一个数插入到已排序的合适位置



时间复杂度$O(N^2)$

空间复杂度$O(1)$

```java
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
```

## 归并排序

> 将该数组平均分成前半部分和后半部分，分别对其归并排序后，合并两个有序数组。

时间复杂度$O(NlogN) $

空间复杂度$O(N)$

```java
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
```



## 快速排序

> “比我小的在我左边，比我大的在我右边”

```java
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
```



## 参考资料

[可视化排序算法](https://visualgo.net/zh/sorting)：冒泡/选择/插入/归并/快排/。。。

[可视化算法2](https://www.cs.usfca.edu/~galles/visualization/)：种类更多

[力扣-排序数组-官方题解](https://leetcode-cn.com/problems/sort-an-array/solution/pai-xu-shu-zu-by-leetcode-solution/)：快排/堆/桶

[复习基础排序算法（Java）](https://leetcode-cn.com/problems/sort-an-array/solution/fu-xi-ji-chu-pai-xu-suan-fa-java-by-liweiwei1419/)：10种