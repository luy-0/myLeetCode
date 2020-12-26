import java.util.Arrays;

public class Offer04 {
    /**
     * 解法1: 半二分 对每个数组进行二分查找, 直到找到. 如果遇到了某个数组的首项大于目标数字,直接跳出
     * 时间 O(mlong(n))
     * 
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int mLen = matrix.length;
        int nLem = matrix[0].length;
        if (matrix[0][0] > target || matrix[mLen - 1][nLem - 1] < target) {
            return false;
        }
        int m = 0;
        while (m < mLen && matrix[m][0] <= target) {
            if (Arrays.binarySearch(matrix[m], target) >= 0) {
                return true;
            }
            m++;
        }
        return false;
    }

    /**
     * 解法2:
     * 双向有序,向左向下移动, 某种意义上也可以理解成双指针
     * Robot xm, yyds!
     * 
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = 0, column = matrix[0].length - 1;
        while (column >= 0 && row < matrix.length) {
            int v = matrix[row][column];
            if (target == v) {
                return true;
            }
            if (target < v) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][] { { -5 } };

        System.out.println(findNumberIn2DArray(matrix, -5));
    }
}