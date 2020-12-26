import java.util.Arrays;

public class Offer53_1 {
    public int search(int[] nums, int target) {
        int count = 0;
        for (int i : nums) {
            if (i == target) {
                count++;
            }
        }
        
        return count;
    }
}