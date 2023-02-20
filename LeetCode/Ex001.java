public class Ex001 {
    public static void main(String[] args) {
        int[] numbers = new int[2];
        //int[] nums = new int[]{2, 7, 11, 15};
        //int[] nums = new int[]{3, 2, 4};
        int[] nums = new int[]{3,3};
        int target = 6;



        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    numbers[0] = i;
                    numbers[1] = j;
                }
            }
        }

        for (int x : numbers) {
            System.out.print(x);
        }

    }
}
