package sorting.bubble;

import java.util.Arrays;

public class bubbleSort {

    /*
    *
    *   첫 시도 풀이 경과 시간 42분
    *   미흡한 점 동작 자체는 완료 되었으나 결국 O(N2) 시간 복잡도를 가짐
    *   더 계산을 할 필요가 있음
     * */
//    public static void main(String[] args) {
//
//        int[] arr = {5, 9, 3, 1, 2, 8, 4, 7, 6};
//
//        for (int i = 0; i < arr.length; i++) {
//
//            for (int j = arr.length - 1; j > 0; j--) {
//
//                if (arr[j] < arr[j - 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j - 1];
//                    arr[j - 1] = temp;
//                }
//            }
//        }
//
//        System.out.println(Arrays.toString(arr));
//    }

    /*
    *   개선 코드
    *   불린으로 스왑이 일어났는지 판단
    *
    *   왜 ? 스왑이 일어나면 정렬이 된다는거지만 그렇지 않으면 정렬될 수가 없기 때문에
    *   더 빠른 속도로 탐색 가능 기존 코드는 불필요한 연산이 포함 되었음
    * */
    public static void main(String[] args) {

        int[] arr = {5, 9, 3, 1, 2, 8, 4, 7, 6};


        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = arr.length - 1; j > i; j--) {

                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }

            }

            if (!swapped) {
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}

/*
*   개선 할점
*   swapped 최적화가 없었던 점: 처음에는 불필요한 반복이 있었기 때문에, 성능을 좀 더 향상시킬 수 있었다
*
* */