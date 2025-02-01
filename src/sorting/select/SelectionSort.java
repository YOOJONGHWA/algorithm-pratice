package sorting.select;

import java.util.Arrays;

/*
*   나열된 배열 리스트에서 가장 작은 값을 찾아서 왼쪽에 값을 이동시키는 알고리즘
* */
public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {6, 1, 7, 8, 9, 3, 5, 4, 2};

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
