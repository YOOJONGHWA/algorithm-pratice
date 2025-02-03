package sorting.insert;

import java.util.Arrays;

/*
*   그림으로 동작하는 것을 보고 쉬울꺼라 생각 했지만
*   쉽지 않았음 손으로 직접 그려보니 이해가 갔는데
*
*   while문이 생각이 났다. 바깥쪽 포문을 결국 다음 숫자들을 제시할뿐이고
*   while문을 돌면서 정렬해 나가면 되는 알고리즘이였음
*
*   I watched an insertion sort process and thought it was easy,
*   but I couldn't write the code, so I used a pen to figure it out.
*
*   Then I got an idea let's use while! The outer loop just moves to the next number,
*   and while helps sort the elements step by step."
* */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 7, 2, 8, 6, 9, 1};

        insertionSort(arr);

        System.out.println("정렬된 배열: " + Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int index = i - 1;

            while (index >= 0 && arr[index] > key) {
                arr[index + 1] = arr[index];
                index--;
            }

            arr[index + 1] = key;
        }
    }
}
