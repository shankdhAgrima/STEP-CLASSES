public class FindMinimumRotatedArray {

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        // If array is already sorted
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Minimum is on the right side
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }

            // Minimum is on the left side
            else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 1, 2};

        int result = findMin(nums);

        System.out.println("Minimum = " + result);
    }
}