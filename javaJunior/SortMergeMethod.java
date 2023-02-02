import java.util.Arrays;

public class SortMergeMethod {
    public static void main(String[] args) {
        int[] arr = {2,3,6,5,9,8,4,2,2,1};
        int [] temp = mergeSort(arr);
        for (int x: temp) {
            System.out.print(x + " ");
        }
    }


    public static int[] mergeSort(int[] src) {
        if (src.length <= 1) return src;
        int[] left = Arrays.copyOfRange(src, 0, src.length / 2);
        //for (int x:left) {
        //System.out.print(x + " ");
        //}
        //System.out.println();
        int[] right = Arrays.copyOfRange(src, left.length, src.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int resIn = 0, leftIn = 0, rightIn = 0;
        int[] result = new int[left.length + right.length];

        while (leftIn < left.length && rightIn < right.length)
            if (left[leftIn] < right[rightIn])
                result[resIn++] = left[leftIn++];
            else result[resIn++] = right[rightIn++];

        while (resIn < result.length)
            if (leftIn != left.length)
                result[resIn++] = left[leftIn++];
            else result[resIn++] = right[rightIn++];

        return result;
    }

}
