package leetcode;

/**
 * @author surui
 * @date 2021/7/8 9:39 下午
 */
public class Solution33 {

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int search = solution33.search(nums, 0);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        int[] doubleNums = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            doubleNums[i] = nums[i];
            doubleNums[i + nums.length] = nums[i];
        }
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        int index = getIndex(maxIndex + 1, maxIndex + nums.length, doubleNums, target);
        if (index == -1) {
            return -1;
        }
        if (target < nums[0]) {
            return index;
        } else {
            return index - nums.length;
        }

    }

    public int getIndex(int left, int right, int[] nums, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }
}
