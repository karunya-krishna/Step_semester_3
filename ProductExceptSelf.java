import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Forward pass: answer[i] = product of everything to the LEFT of i
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Backward pass: multiply in product of everything to the RIGHT of i
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        ProductExceptSelf sol = new ProductExceptSelf();
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{1, 2, 3, 4})));          // [24, 12, 8, 6]
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));     // [0, 0, 9, 0, 0]
    }
}