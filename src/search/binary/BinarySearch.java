package search.binary;

import java.util.Arrays;

public class BinarySearch {

    /*
    *   정렬이 되어 있어야 동작할수 있는 알고리즘
    *   반면 선형 탐색은 정렬되어 있지 않아도 동작함
    *
    * */
    public static void main(String[] args) {

        int[] arr = {5, 9, 3, 1, 2, 8, 4, 7, 6};
        Arrays.sort(arr);

        int findNum = 6;
        String result = binarySearch(findNum, arr);
        System.out.println(result);
    }
    public static String binarySearch(int findNum, int[] arr) {

        int left = 0 , right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == findNum) return "찾음";
            if (arr[mid] < findNum) left = mid + 1;
            if (arr[mid] > findNum) right = mid - 1;
        }

        return "못 찾음";
    }
}
