import java.util.Arrays;

public class ArrayExamples {
    public static void main(String[] args) {
        // 1d array
        int[] arr1d = new int[6];
        for (int i = 0; i < 6; i++) {
            arr1d[i] = i;
        }

        // 2d array
        int[][] arr2d = new int[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                arr2d[i][j] = i + 1;
            }
        }

        // alternative ways
        arr1d = new int[] {1, 3, 5, 2, 4};
        Arrays.sort(arr1d); // arr1d = [1, 2, 3, 4, 5]
    }
}
